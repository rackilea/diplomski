public static <T> T as(Class<T> clazz, Object o){
    if(clazz.isInstance(o)){
        return clazz.cast(o);
    }
    return null;
}

as(A.class, new Object()) --> null
as(B.class, new B())  --> B