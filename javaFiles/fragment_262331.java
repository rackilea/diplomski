package com.stackoverflow.so22075052;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class F {
    public static void main(final String[] args) {
        // fill a list
        final List<Object> objects = new ArrayList<>();
        objects.add(A.of(1));
        objects.add(B.of("2"));

        // introspect
        for (final Object object : objects) {
            ReflectionUtils.doWithFields(object.getClass(), new ReflectionUtils.FieldCallback() {
                @Override
                public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
                    ReflectionUtils.makeAccessible(field);
                    System.out.printf("%s - %s\n", field.getName(),  ReflectionUtils.getField(field, object));
                }
            });
        }
    }

    static class A {
        private int age;

        public static A of(final int age) {
            final A a = new A();
            a.age = age;
            return a;
        }
    }

    static class B {
        private String string;

        public static B of(final String string) {
            final B b = new B();
            b.string = string;
            return b;
        }
    }
}