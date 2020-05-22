spnego-client {
    com.sun.security.auth.module.Krb5LoginModule required;
};

spnego-server {
    com.sun.security.auth.module.Krb5LoginModule required
    useKeyTab=true
    keyTab="appserver.keytab"
    principal=aqw
    storeKey=true;
};