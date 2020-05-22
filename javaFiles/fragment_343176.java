package myA;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import org.jgroups.JChannel;

public class Loader 
{
    Class<?> clazz;
    String user_name=System.getProperty("user.name", "n/a");

    private void start() throws Exception 
    {
        if (this.clazz == null)
            throw new Exception("Channel class was not loaded properly");

        Object channel  = this.clazz.newInstance(); // use the default config, udp.xml
        Method chatCluster = this.clazz.getDeclaredMethod("connect", new Class[] { String.class });
        chatCluster.invoke(channel, "ChatCluster");
    }

    public void loadMe() throws Exception
    {
        URL classUrl;
        classUrl = new URL("file:///home/myJars/jgroups-3.4.2.Final.jar");
        URL[] classUrls = { classUrl };
        URLClassLoader ucl = new URLClassLoader(classUrls);
        Class<?> c = ucl.loadClass("org.jgroups.JChannel");
        for(Field f: c.getDeclaredFields()) 
        {
            System.out.println("Field name=" + f.getName());
        }
        this.clazz = c;
        Object instance = c.newInstance();  
        //Method theMethod = c.getMethod("main");
        //theMethod.invoke(instance);
     }

     public static void main(String[] args) throws Exception 
     {
         Loader loader = new Loader();
         loader.loadMe();
         loader.start();
     }
}