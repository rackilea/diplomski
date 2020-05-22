try {
 Context initCxt =  new InitialContext();
 Boolean isConn =  (Boolean)initCxt.lookup("java:comp/env/isConnected");
 System.out.println(isConn.toString());
 // one could use relative names into the sub-context
 Context envContext = (Context) initCxt.lookup("java:comp/env");
 Boolean isConn2 = (Boolean)envContext.lookup("isConnected");
 System.out.println(isConn2.toString());
} catch (NamingException e) {
 e.printStackTrace();
}