try {
    MyArgumentClass argument = new MyArgumentClass();
    MyMainClass instance = new MyMainClass(argument);
    method = MyMainClass.class.getDeclaredMethod(methodName, MyArgumentClass.class);
    ResultClass result = (ResultClass) method.invoke(instance, myArgument);
    return result;
}
catch(Exception e)
{
    e.printStackTrace();
    System.exit(1);
    return null;
}