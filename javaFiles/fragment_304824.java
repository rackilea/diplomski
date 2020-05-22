package com.stack;

public class Test {
    public static class Example {
        public static class Cow {
            public static class Hoof {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Class<?> cl1 = Class.forName("com.stack.Test$Example$Cow$Hoof");
        Class<?> cl2 = Class.forName("com.stack.Test.Example.Cow.Hoof");
        System.out.println(cl1.getName());
        System.out.println(cl1.getSimpleName());
        System.out.println(cl1.getCanonicalName());
        System.out.println();
        System.out.println(cl2.getName());
        System.out.println(cl2.getSimpleName());
        System.out.println(cl2.getCanonicalName());
    }
}