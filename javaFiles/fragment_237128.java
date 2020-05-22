class MyGenerator extends .... {

public void setIdForObject(Class clazz, Long id) {
    //once you use this API, the next time an object of 
    //type clazz is saved the id is used
}

public void setIdForObject(Class clazz, Long id, Matcher matcher) {
    //once you use this API, the next time an object of 
    //type clazz is saved and the matcher matches yes the id will be 
    //assigned. Your matcher can match properties like name, age etc
    //to say the matched object
}
}