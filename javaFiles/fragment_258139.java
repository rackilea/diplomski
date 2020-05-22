try{
  conn.setAutoCommit(false);
  //do stuff
  conn.commit();
}catch(Exception e){
  //failure logic
  try{
    conn.rollback();
  }catch(Exception e){
    //rollback fail logic
  }
  //more failure logic
}