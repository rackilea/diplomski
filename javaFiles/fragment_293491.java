package com.stackoverflow.q14521882;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Test {

    private Set<Long> set = new HashSet<Long>();

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Field field = test.getClass().getDeclaredField("set");
        Object object = field.get(test);
        if (object instanceof Collection) {
            ((Collection) object).add("string");
        }
        System.out.println(test.set.iterator().next().getClass()); // CCE!
    }

}