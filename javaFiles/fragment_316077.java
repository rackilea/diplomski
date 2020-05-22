try {
    //creating parent object
    Object outer = new MyBigClass();

    //creating inner class object
    Class<?> innerClass = Class.forName("MyBigClass$MyInnerClass");
    Constructor<?> constructor = innerClass.getDeclaredConstructor(MyBigClass.class);//inner object must know type of outer class
    constructor.setAccessible(true);//private inner class has private default constructor
    Object child = constructor.newInstance(outer);//inner object must know about its outer object

    //invoking method on inner class object
    Method method = innerClass.getDeclaredMethod("wantedMethod",new Class<?>[]{});
    method.setAccessible(true);//in case of unaccessible method
    method.invoke(child,new Object[]{});

} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}