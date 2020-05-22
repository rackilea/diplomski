try{
    throw new Exception("original exception");
}
catch(Exception e){
    //you should do some query on what kind of exception caught here
    e = new CustomException("new exception");
}