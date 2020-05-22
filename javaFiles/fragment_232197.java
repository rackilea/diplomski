Field[] fields = obj.getClass().getSuperclass().getDeclaredFields();
for(Field field : fields) {
    if(field.getType() == String.class) { //assume the type is String

    }
}