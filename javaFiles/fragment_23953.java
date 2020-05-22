try{
    try{
        throw new Exception("original exception");
    }
    catch(Exception e){
        throw new CustomException();
    }
}
catch(CustomException e){
   //overrides original exception
}