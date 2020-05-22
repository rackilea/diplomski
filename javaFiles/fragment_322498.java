Hashtable props = new Hashtable();
            String principalName = "username@mydomain.com";
            props.put(Context.SECURITY_PRINCIPAL, principalName);
            props.put(Context.SECURITY_CREDENTIALS, "mypassword");
            DirContext context;

                //try to authenticate
            try {

                   context = com.sun.jndi.ldap.LdapCtxFactory.getLdapCtxInstance("LDAP://myldap.mydomain.com:389" + '/', props);
                   context.close();                    
            }