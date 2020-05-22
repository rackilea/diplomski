public java.util.List<Object> objectCreationTest(){
    java.util.List<Object> objectList = new java.util. ArrayList<Object>();
    for(int i = 0 ; i <1000;i++){
        Object e = new Object(); 
        objectList.add(e);    
    }
    return objectList;
}