spnego-client {
    com.sun.security.auth.module.Krb5LoginModule required;
    storeKey=true
    useKeyTab=true
    keyTab="file:///C:/sys-spn.keytab"
    principal=sys-spn;
};