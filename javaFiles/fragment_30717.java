//use MyClass.class.getDeclaredFields() if you want the fields only for this class.
//.getFields() returns the fields for all the class hierarchy
for(Field field : MyClass.class.getFields()){
    isSearchable s = field.getAnnotation(isSearchable.class);
    if (s != null) {
        //field has the annotation isSearchable
    } else {
        //field has not the annotation
    }
}