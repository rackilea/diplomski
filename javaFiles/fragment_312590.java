package com.frybits;

class JavaClass {

    void someFunction() {
        println(KotlinClass.foo()); //Prints "1"
        println(KotlinClass.Companion.bar()); //Prints "2". This is the only way to use [bar()] in Java.
        println(KotlinClass.Companion.foo()); //To show that [Companion] is still the holder of the function [foo()]
    }

    //Because I'm way to lazy to keep typing [System.out], but I still want this to be compilable.
    void println(Object o) {
        System.out.println(o);
    }
}