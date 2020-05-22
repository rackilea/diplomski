package com.example.app;

import org.sample.SampleEnum;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import static java.util.Arrays.asList;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("v2.0: " + asList(SampleEnum.values()));
        try {
            URLClassLoader loader1 = new CustomURLClassLoader(
                    new URL[] { new File("../sample-1.0/target/sample-1.0.jar").toURL() });

            Class<?> c1 = loader1.loadClass("org.sample.SampleEnum");

            System.out.println("v1.0: " + asList(c1.getEnumConstants()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class CustomURLClassLoader extends URLClassLoader
{
    public CustomURLClassLoader(URL[] urls)
    {
        super(urls);
    }

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();

                // First, look in the current ClassLoader
                long t1 = System.nanoTime();
                try {
                    c = findClass(name);
                } catch (ClassNotFoundException ex) {
                    // ClassNotFoundException thrown if class not found
                }

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();

                // Lastly, look in the parent ClassLoader
                try {
                    if (getParent() != null) {
                        c = super.loadClass(name, resolve);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }

            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}