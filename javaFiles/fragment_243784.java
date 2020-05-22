public String getFieldName(){
    Field[] fields = getClass().getDeclaredFields();
    for(Field f: fields){
        if(f.isAnnotationPresent(YourAnnotation.class)){
             return f.getName();
        }
    }
    // do whatever if a valid field wasn't found
}