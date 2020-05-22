@SuppressWarning( "unchecked" )
Class<? Callable<Integer>> getClass(String className)
{
    Class clazz = Class.forName(className);
    via reflection, check generic super interfaces of clazz
    if there's no Callable<Integer> super interface
        throw "className is not a Callable<Integer>"

    // we have *checked*, the following cast is safe
    return (Class<? Callable<Integer>>)clazz; 
}