private static List getClassesFromJARFile(String jar, String packageName) throws Error
{
    final List classes = new ArrayList();
    JarInputStream jarFile = null;
    try
    {
        jarFile = new JarInputStream(new FileInputStream(jar));
        JarEntry jarEntry;
        do 
        {       
            try
            {
                jarEntry = jarFile.getNextJarEntry();
            }
            catch(IOException ioe)
            {
                throw new CCException.Error("Unable to get next jar entry from jar file '"+jar+"'", ioe);
            }
            if (jarEntry != null) 
            {
                extractClassFromJar(jar, packageName, classes, jarEntry);
            }
        } while (jarEntry != null);
        closeJarFile(jarFile);
    }
    catch(IOException ioe)
    {
        throw new CCException.Error("Unable to get Jar input stream from '"+jar+"'", ioe);
    }
    finally
    {
        closeJarFile(jarFile);
    }
   return classes;
}
private static void extractClassFromJar(final String jar, final String packageName, final List classes, JarEntry jarEntry) throws Error
{
    String className = jarEntry.getName();
    if (className.endsWith(".class")) 
    {
        className = className.substring(0, className.length() - ".class".length());
        if (className.startsWith(packageName))
        {
            try
            {
                classes.add(Class.forName(className.replace('/', '.')));
            } catch (ClassNotFoundException cnfe)
            {
                throw new CCException.Error("unable to find class named " + className.replace('/', '.') + "' within jar '" + jar + "'", cnfe);
            }
        }
    }
}
private static void closeJarFile(final JarInputStream jarFile)
{
    if(jarFile != null) 
    { 
        try
        {
            jarFile.close(); 
        }
        catch(IOException ioe)
        {
            mockAction();
        }
    }
}