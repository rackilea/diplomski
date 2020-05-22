//Load the class 

Class clazz = Class.forName("your.class.ClassName");
Field field = clazz.getField("fieldName")
if(field!=null){
 //field exist now check if its initialized or not, or if its primitive field check against its assumed initialized value
 if(ClassName.fieldName!=null){
    //yes initilized
 }
}