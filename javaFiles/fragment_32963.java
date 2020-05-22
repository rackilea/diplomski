com.sun.security.jgss.krb5.initiate {
com.sun.security.auth.module.Krb5LoginModule required;
};

com.sun.security.jgss.krb5.accept {
com.sun.security.auth.module.Krb5LoginModule required
storeKey=true
useKeyTab=true
keyTab="file:///C:/Program Files/Apache Software Foundation/Tomcat 8.5/conf/test.keytab"
principal="HTTP/santi.dev-mitrol.net.dev-mitrol.local";
};