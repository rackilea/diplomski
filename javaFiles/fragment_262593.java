Context ic = new InitialContext();
UserTransaction ut =
(UserTransaction) ic.lookup("java:comp/UserTransaction");
ut.begin();
// use connection here
ut.commit();