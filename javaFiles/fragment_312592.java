package com.frybits;

class JavaClass {

    void someFunction() {
        //Example using @JvmField
        println(KotlinClass.foo); //Prints "1"
        KotlinClass.foo = 3;

        //Example using 'const val'
        println(KotlinClass.dog); //Prints "1". Notice the lack of a getter function

        //Example of not using either @JvmField, @JvmStatic, or 'const val'
        println(KotlinClass.Companion.getBar()); //Prints "2"
        KotlinClass.Companion.setBar(3); //The setter for [bar]

        //Example of using @JvmStatic instead of @JvmField
        println(KotlinClass.getCat());
        KotlinClass.setCat(0);
    }

    void println(Object o) {
        System.out.println(o);
    }
}