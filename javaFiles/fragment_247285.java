import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import de.tarent.ldap.LDAPException;
import de.tarent.ldap.LDAPManager;

/**
 * @author kirchner
 * 
 * Preferences im LDAP
 */
public class LDAPSystemPreferences extends AbstractPreferences {
    LDAPManager     ldm         = null;
    Properties      properties  = new Properties();
    //Map für key/value der Preferences
    Map             cache       = new HashMap();
    //Map für timestamp der Preferences
    Map             timestamp   = new HashMap();
    private Boolean deleted     = Boolean.FALSE;