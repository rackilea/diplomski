public void yourUpdateMethod(){
User user = (User)session.get(User.class,userId);
if(!(user==null)){
 user.setNoLock(true);
// Above line is just an example, set whatever you want to, ideally this should be done in Service layer, but okay for now
    session.merge(user);
    session.flush();
  }
}