package io.github.gabrielbb.java.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @author Gabriel Basilio Brito
 * @since 12/26/2016
 * @version 1.1
 */
public class ClassesAndInterfacesFromJar {

    public static List<Class> getJarClasses(String jarPath) throws IOException, ClassNotFoundException {
        File jarFile = new File(jarPath);
        return getJarClasses(jarFile);
    }

    public static List<Class> getJarClasses(File jar) throws IOException, ClassNotFoundException {
        ArrayList<Class> classes = new ArrayList();
        JarInputStream jarInputStream = null;
        URLClassLoader cl;

        try {
            cl = URLClassLoader.newInstance(new URL[]{new URL("jar:file:" + jar + "!/")}); // To load classes inside the jar, after getting their names

            jarInputStream = new JarInputStream(new FileInputStream(
                    jar)); // Getting a JarInputStream to iterate through the Jar files 

            JarEntry jarEntry = jarInputStream.getNextJarEntry();

            while (jarEntry != null) {
                if (jarEntry.getName().endsWith(".class")) { // Avoiding non ".class" files
                    String className = jarEntry.getName().replaceAll("/", "\\."); // The ClassLoader works with "." instead of "/"
                    className = className.substring(0, jarEntry.getName().length() - 6);  // Removing ".class" from the string
                    Class clazz = cl.loadClass(className); // Loading the class by its name
                    classes.add(clazz);
                }

                jarEntry = jarInputStream.getNextJarEntry(); // Next File
            }
        } finally {
            if (jarInputStream != null) {
                jarInputStream.close(); // Closes the FileInputStream
            }
        }
        return classes;
    }

    // Main Method for testing purposes
    public static void main(String[] args) {
        try {
            String jarPath = "C://Test.jar";
            List<Class> classes = getJarClasses(jarPath);

            for (Class c : classes) {
                // Here we can use the "isInterface" method to differentiate an Interface from a Class
                System.out.println(c.isInterface() ? "Interface: " + c.getName() : "Class: " + c.getName());
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }