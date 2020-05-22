import javax.naming.directory.*;

//then these are obsolete:
import javax.naming.directory.SearchControls;  
import javax.naming.directory.SearchResult; 
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem; 

// however it is only on package level, not recursive so
import javax.naming.*;
// doesn't import automatically javax.naming.ldap.*; and you will need to provide it also
import javax.naming.ldap.*;