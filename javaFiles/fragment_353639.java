for (Method method : testClass.getMethods())
{
    if (method.isAnnotationPresent(InstallerMethod.class))
    {
        // do something
    }
}