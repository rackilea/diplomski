import java.security.cert.X509Certificate;
import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;

X509Certificate[] certs = (X509Certificate[])request.getAttribute("javax.servlet.request.X509Certificate");
if ((certs == null) || (certs.length == 0)) {
   return null;
}

String name = certs[0].getSubjectX500Principal().getName(); // if you are looking for issuer then use cert[0].getIssuerX500Principal().getName();
LdapName ldapName = null;
try {
   ldapName = new LdapName(name);
} catch (InvalidNameException e) {
   throw new RuntimeException(e);
}

for (Rdn rdn : ldapName.getRdns()) {
   String type = rdn.getType();
   if ("CN".equals(type)) { 
        String issuedTo = (String)rdn.getValue();
   }
}