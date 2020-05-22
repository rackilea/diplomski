package com.frybits;

class JavaClass {

    void someFunction() {

        println(KotlinUtils.TAG); //Example of printing [TAG]


        //Example of not using @JvmField.
        println(KotlinUtils.getFoo()); //Prints "1"
        KotlinUtils.setFoo(3);

        //Example using @JvmField
        println(KotlinUtils.bar); //Prints "2". Notice the lack of a getter function
        KotlinUtils.bar = 3;

        //Since this is a top level variable, no need for annotations to use this
        //But it looks awkward without the @JvmField
        println(KotlinUtils.getGENERATED_VAL());

        //This is how accessing a top level function looks like
        KotlinUtils.doSomethingAwesome();
    }

    void println(Object o) {
        System.out.println(o);
    }
}