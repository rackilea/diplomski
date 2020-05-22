package com.pholser;

import java.lang.reflect.Method;

public class ClassLoading {
    public static class CustomLoader extends ClassLoader {
        public Object load(String className, Class<?>[] paramTypes, Object[] params) throws Exception {
            Class<?> loaded = loadClass(className);
            return loaded.getConstructor(paramTypes).newInstance(params);
        }
    }

    public static class ACustomObject {
    }

    public void foo(ACustomObject a) {
        System.out.println("foo");
    }

    public static Object newCustomObject() throws Exception {
        return new CustomLoader().load("com.pholser.ClassLoading$ACustomObject", new Class<?>[0], new Object[0]);
    }

    public static void main(String[] args) throws Exception {
        ClassLoading obj = new ClassLoading();

        Method m = obj.getClass().getDeclaredMethod("foo", ACustomObject.class);

        m.invoke(obj, newCustomObject());
    }
}