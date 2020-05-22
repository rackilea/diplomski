package com.frybits;

class JavaClass {

    void someFunction() {
        println(KotlinClass.foo); //Direct read of [foo] in [KotlinClass] singleton

        println(KotlinClass.getCat()); //Getter of [cat]
        KotlinClass.setCat(0); //Setter of [cat]

        println(KotlinClass.getCustomClassName()); //Example of using a function of this 'object' class

        println(KotlinClass.INSTANCE.getBar()); //This is what the singleton would look like without using annotations
        KotlinClass.INSTANCE.setBar(23);

        println(KotlinClass.INSTANCE.someOtherFunction()); //Accessing a function in the object class without using annotations
    }

    void println(Object o) {
        System.out.println(o);
    }
}