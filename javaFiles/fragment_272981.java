com.sun.security.jgss.initiate {
    com.sun.security.auth.module.Krb5LoginModule required
    useKeyTab=true
    keyTab="/etc/myapp/conf/myapp.keytab"
    useTicketCache=true
    principal="myuserprincipal"
    debug=true;
};

com.sun.security.jgss.accept {
    com.sun.security.auth.module.Krb5LoginModule required
    useKeyTab=true
    keyTab="/etc/myapp/conf/myapp.keytab"
    useTicketCache=false
    principal="myserviceprincipal/my.server.com"
    debug=true;
};