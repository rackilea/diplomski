LdapClient ldapClient = new LdapClient();
Boolean foundUserInAD = Boolean.FALSE;
foundUserInAD = ldapClient.userIsInAD(userName, password);

if(foundUserInAD) {
    //Do stuff.
}