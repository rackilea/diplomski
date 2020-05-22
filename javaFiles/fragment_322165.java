try{
    Class<?> klass = Class.forName("[classname]");
    object = ([ObjectType]) klass.newInstance();

    String methodName = "setAddress"; //for example
    Method method = object.getClass().getMethod(methodName, java.lang.String.class);

    method.invoke(object, "[address]");
} catch(NoSuchMethodException e){
    e.printStackTrace();
}