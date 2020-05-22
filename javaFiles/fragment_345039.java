public static <T>T freeze(T obj) throws IllegalAccessException {
    if(obj!=null){
        Field[] fields=obj.getClass().getDeclaredFields();
        for(Field field:fields){
            //update accessibility 
            field.setAccessible(true);
            if(field.getType().equals(Map.class)){
                //Convert the map field to Collections.unmodifiableMap() object and update the field
                field.set(obj, Collections.unmodifiableMap((Map<?, ?>) field.get(obj)));
            }
        }
    }
    return obj;
}