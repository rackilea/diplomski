try{
    //do whatever
}catch(JsonSyntaxException e){
    e.printStackTrace();
    // throw new Exception(e); //checked exception
}catch(IOException e){
    e.printStackTrace();
}