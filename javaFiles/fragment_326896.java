class B{

    public void execute(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class mainClass = object.getClass();

        // for your purpose
        // Method method = mainClass.getMethod("setLabelText", String.class);
        // String text = "Some Text";
        // method.invoke(object, text);

        // for demonstration
        Method method = mainClass.getMethod("getUserInput");
        System.out.println(method.invoke(object));
    }

}