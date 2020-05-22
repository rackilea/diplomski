@POST
 @Path("/crunchifyService")
 @Produces("application/json")
 @Consumes("application/json")
 public Modele auth (Log user) throws ClassNotFoundException, SQLException{
   
  Auth_Ctrl auth = new Auth_Ctrl();
  int result =auth.connect(user.user, user.pass);
  
  return auth.info(result);
 }