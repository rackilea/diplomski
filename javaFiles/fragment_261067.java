package org.aspectj.weaver.loadtime.filter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class FilterAgent {

    private static Instrumentation s_instrumentation;

    // Use our own version of ClassFileTransformer that would filter out selected classloaders 
    private static ClassFileTransformer s_transformer = new ClassPreprocessorFilteredAdapter();

    /**
     * JSR-163 preMain Agent entry method
     *
     * @param options
     * @param instrumentation
     */
    public static void premain(String options, Instrumentation instrumentation) {
        /* Handle duplicate agents */
        if (s_instrumentation != null) {
            return;
        }
        s_instrumentation = instrumentation;
        s_instrumentation.addTransformer(s_transformer);
    }

    public static Instrumentation getInstrumentation() {
        if (s_instrumentation == null) {
            throw new UnsupportedOperationException("Java 5 was not started with preMain -javaagent for AspectJ");
        }
        return s_instrumentation;
    }
}
//-----------------------------------------------------------------------------------
package org.aspectj.weaver.loadtime.filter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.weaver.loadtime.Aj;
import org.aspectj.weaver.loadtime.ClassPreProcessor;


public class ClassPreprocessorFilteredAdapter implements ClassFileTransformer {

    /**
     * Concrete preprocessor.
     */
    private static ClassPreProcessor s_preProcessor;

    private static Map<String, String> ignoredClassloaderNames = new HashMap<String, String>();

    static {
        try {
            s_preProcessor = new Aj();
            s_preProcessor.initialize();


            String ignoredLoaders = System.getProperty("org.aspectj.weaver.loadtime.filter", "");
            if (ignoredLoaders.length() > 0) {
                String[] loaders = ignoredLoaders.split(",");

                for (String s : loaders) {
                    s = s.trim();
                    ignoredClassloaderNames.put(s, s);
                    System.out.println("---> Will filtered out classloader: " + s);
                }
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("could not initialize JSR163 preprocessor due to: " + e.toString());
        }
    }

    /**
     * Invokes the weaver to modify some set of input bytes.
     * 
     * @param loader the defining class loader
     * @param className the name of class being loaded
     * @param classBeingRedefined is set when hotswap is being attempted
     * @param protectionDomain the protection domain for the class being loaded
     * @param bytes the incoming bytes (before weaving)
     * @return the woven bytes
     */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException {
        if (classBeingRedefined != null) {
            System.err.println("INFO: (Enh120375):  AspectJ attempting reweave of '" + className + "'");
        }

        String loaderName = loader.getClass().getName();
        if (shouldIgnoreClassLoader(loaderName)) {
            return bytes;
        }
        return s_preProcessor.preProcess(className, bytes, loader, protectionDomain);
    }

    private boolean shouldIgnoreClassLoader(String loaderName) {
        boolean result = false;
        String ignoredLoader = ignoredClassloaderNames.get(loaderName);
        if (ignoredLoader != null) {
            result = true;    // if the loader name exists in the map we will ignore weaving
        }
        return result;
    }
}