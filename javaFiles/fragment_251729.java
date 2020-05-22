package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TempClass {
    public static void main(String[] args) throws ParseException, InterruptedException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        new TempClass().function();
    }

    private void function() throws NoSuchMethodException, InterruptedException, InvocationTargetException, IllegalAccessException {
        final Class aClass = this.getClass();
        List<Method> methods = new ArrayList<Method>() {{
            add(aClass.getDeclaredMethod("command1"));
            add(aClass.getDeclaredMethod("command2"));
        }};
        for (Method method : methods) {
            method.setAccessible(true);
            method.invoke(this);
            Thread.sleep(1000);
        }
    }

    private void command1() {
        System.out.println("command1");
    }

    private void command2() {
        System.out.println("command2");
    }
}