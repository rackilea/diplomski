try{
    Foo foo = new Foo();
    foo.close(); // handled automatically by  try-with-resources 
    return 1;
}       
catch (RuntimeException e){
    //handle exception without throwing
}
return 2;