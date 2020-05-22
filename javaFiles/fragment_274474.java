try(Foo foo = new Foo()){
    return 1;
}
catch (RuntimeException e){
    //handle exception without throwing
}
return 2;