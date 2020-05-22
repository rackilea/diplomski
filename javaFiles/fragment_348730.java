com.sun.security.jgss.login {
com.sun.security.auth.module.Krb5LoginModule required
useTicketCache=true
doNotPrompt=true
debug=true;
};

com.sun.security.jgss.initiate {
com.sun.security.auth.module.Krb5LoginModule required
useTicketCache=true 
principal="saphanauser"
debug=true;
};