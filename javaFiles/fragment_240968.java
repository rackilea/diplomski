package org.bhate.ldap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.spi.NamingManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.security.BadCredentialsException;


public class LdapUtil {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LdapUtil.class);

    @SuppressWarnings("serial")
    final static Map<String, String> errorCodesMap = new HashMap<String, String>() {
        {
            put("525", "user not found");
            put("52e", "invalid credentials");
            put("530", "not permitted to logon at this time");
            put("531", "not permitted to logon at this workstation");
            put("532", "password expired");
            put("533", "account disabled");
            put("701", "account expired");
            put("773", "user must reset password");
            put("775", "user account locked");
        }
    };

    private static Collection<String> ldapServers;
    private static String domainName;
    private static Pattern PATTERN;

    public static DirContext getDirContext(String url, String domainName,
            String userName, String password) throws NamingException {
        Hashtable<String, Object> env = getEnv(url, domainName, userName,
                password);
        return new InitialDirContext(env);
    }

    public static Collection<String> getLdapServers(String ldapDomain,
            boolean useSsl) throws NamingException {
        Collection<String> serverRecords = getSRVRecords(ldapDomain);
        serverRecords = reOrder(serverRecords);
        Collection<String> serverNames = new LinkedHashSet<String>();
        String protocol = "ldap" + (useSsl ? 's' : "");
        for (String s : serverRecords) {
            String hostName = s.substring(s.lastIndexOf(' ') + 1,
                    s.length() - 1);
            serverNames.add(protocol + "://" + hostName);
        }
        return serverNames;
    }

    private static Collection<String> reOrder(Collection<String> serverRecords) {
        return serverRecords;
    }

    private static Collection<String> getSRVRecords(String ldapDomain)
            throws NamingException {
        DirContext context = (DirContext) NamingManager.getURLContext("dns",
                new Hashtable<String, Object>());
        String ldapDNSUrl = "dns:///_ldap._tcp." + ldapDomain;
        String[] attrIds = { "SRV" };
        Attributes attributes = context.getAttributes(ldapDNSUrl, attrIds);
        Attribute servers = attributes.get("SRV");
        int L = servers.size();
        Collection<String> serverRecords = new TreeSet<String>();
        for (int i = 0; i < L; i++) {
            String s = (String) servers.get(i);
            if (PATTERN.matcher(s).find())
                serverRecords.add(s);
        }
        return serverRecords;
    }

    public static void authenticate(String userName, String password) {
        String msg = "Unable authenticate user {} with {}";
        for (String url : ldapServers) {
            DirContext ctx = null;
            try {
                ctx = getDirContext(url, domainName, userName, password);
                LOGGER
                        .info("Authenticated user {} on server {}", userName,
                                url);
                return;
            } catch (NamingException e) {
                LOGGER.error(msg, userName, url);
                String m = NestedExceptionUtils.buildMessage(e.getMessage(), e
                        .getCause());
                LOGGER.error(m, e);
                if (e instanceof AuthenticationException
                        && e.getMessage().startsWith("[LDAP: error code 49"))
                    throwMeanigfulEx(userName, url, e);
            } finally {
                close(ctx);
            }
        }
        LOGGER.error(msg, userName, "any available server");
        throw new BadCredentialsException(
                "Unable to authenticate : Please contact application support team");
    }

    public static void init(String dnsServerName, String domainName,
            String serverFilter, boolean useSsl) {
        PATTERN = Pattern.compile(serverFilter);
        try {
            LdapUtil.domainName=domainName;
            ldapServers = getLdapServers(dnsServerName, useSsl);

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(
                        "LDAP servers available in domain {} to connect {}",
                        dnsServerName, ldapServers);
            }
        } catch (NamingException e) {
            throw new RuntimeException("Unable retrieve ldapServers for "
                    + dnsServerName, e);
        }
    }

    private static void throwMeanigfulEx(String userName, String url,
            NamingException e) {
        String separator = ", data ";
        String m = e.getMessage();
        int strt = m.lastIndexOf(separator) + separator.length();
        int end = m.lastIndexOf(", vece");
        String code = m.substring(strt, end);
        throw new BadCredentialsException("Unable to authenticate : "
                + errorCodesMap.get(code));
    }

    private static void close(DirContext ctx) {
        if (ctx != null)
            try {
                ctx.close();
            } catch (NamingException e) {
                LOGGER.error("Unable to close context", e);
            }
    }

    private static Hashtable<String, Object> getEnv(String url,
            String domainName, String userName, String password) {
        Hashtable<String, Object> env = new Hashtable<String, Object>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.REFERRAL, "follow");
        env.put(Context.PROVIDER_URL, url);
        env.put("com.sun.jndi.ldap.connect.timeout", "2000");
        // env.put("com.sun.jndi.ldap.trace.ber", System.err);
        // env.put("javax.net.ssl.trustStoreType", "JKS");
        // env.put(Context.SECURITY_PROTOCOL, "ssl");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, getPrincipal(domainName, userName));
        env.put(Context.SECURITY_CREDENTIALS, password);
        return env;
    }

    private static Object getPrincipal(String domainName, String userName) {
        return domainName + "\\" + userName;
    }


    public static void main(String[] args) throws NamingException {
        init("uk.mydomain.com", "DOMAINNAME", "serv10.*|server.*",true);
        System.out.println(ldapServers.size());
        System.out.println(ldapServers);
        if (args.length == 2)
            authenticate(args[0], args[1]);
    }


    //
    // public static InitialLdapContext getLdapContext(String userName,
    // String domainName, String password, String url)
    // throws NamingException {
    // Hashtable<String, Object> env = getEnv(url, domainName, userName,
    // password);
    // Control[] connCtls = new Control[] { new Control() {
    // private static final long serialVersionUID = 1L;
    //
    // public byte[] getEncodedValue() {
    // return null;
    // }
    //
    // public String getID() {
    // return "1.2.840.113556.1.4.1781";
    // }
    //
    // public boolean isCritical() {
    // return true;
    // }
    // } };
    // return new InitialLdapContext(env, connCtls);
    // }


}