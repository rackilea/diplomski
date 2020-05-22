com.sun.security.jgss.login {
com.sun.security.auth.module.Krb5LoginModule required
useTicketCache=true
doNotPrompt=true
debug=true;
};

com.sun.security.jgss.initiate {
com.sun.security.auth.module.Krb5LoginModule required
useTicketCache=true 
debug=true;
};

com.sun.security.jgss.accept {
com.sun.security.auth.module.Krb5LoginModule required
storeKey=true
keyTab="C:/krb/keytab/krb5_hdb.keytab"
useKeyTab=true
realm="DOMAINNAME.NEW"
principal="HDB/LINUX.DOMAINNAME.NEW"
isInitiator=false
debug=true;
};