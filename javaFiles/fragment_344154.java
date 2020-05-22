package net.thadir.dataservices.ldap.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import javax.naming.Binding;
import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.ldap.LdapName;

public class FixedLdapTemplate extends LdapTemplate {
  private static final Logger LOGGER = LoggerFactory.getLogger(FixedLdapTemplate.class);

  public FixedLdapTemplate(LdapContextSource contextSource) {
    super(contextSource);
  }

  /**
   * Delete all subcontexts including the current one recursively.
   *
   * @param ctx The context to use for deleting.
   * @param name The starting point to delete recursively.
   * @throws NamingException if any error occurs
   */
  @Override
  protected void deleteRecursively(DirContext ctx, Name name) {
    NamingEnumeration enumeration = null;
    try {
      enumeration = ctx.listBindings(name);
      while (enumeration.hasMore()) {
        Binding binding = (Binding) enumeration.next();
        String bindingName = binding.getName();
        LdapName childName = org.springframework.ldap.support.LdapUtils.newLdapName(fixJDNIBug(bindingName));
        childName.addAll(0, name);
        deleteRecursively(ctx, childName);
      }
      ctx.unbind(name);
      LOGGER.debug("Entry {} deleted", name);
    }
    catch (javax.naming.NamingException e) {
      throw org.springframework.ldap.support.LdapUtils.convertLdapException(e);
    }
    finally {
      try {
        if (enumeration != null) {
          enumeration.close();
        }
      }
      catch (Exception e) {
        LOGGER.trace("Never mind this", e);
      }
    }
  }

  /**
   * Becouse somhow JDNI things that if you have a binding with some special characters it adds some extra " to the beginnin and the end. We have to remove it.
   *
   * @param bindingName
   * @return
   */
  private static String fixJDNIBug(String bindingName) {
    String result = bindingName;
    if(result.contains("/") && result.startsWith("\"") && result.endsWith("\"")) {
      result = result.substring(1,bindingName.length()-1);
    }
    return result;
  }
}