@file:JvmName("KotlinClass") //This provides a name for this file, so it's not defaulted as [KotlinClassKt] in Java
package com.frybits

class KotlinClass {

    companion object {

        //This annotation tells Kotlin to not generate the getter/setter functions in Java. Instead, this variable should be accessed directly
        //Also, this is similar to [@JvmStatic], in which it tells Java to treat this as a static variable to [KotlinClass].
        @JvmField
        var foo: Int = 1

        //If you want something akin to [final static], and the value is a primitive or a String, you can use the keyword [const] instead
        //No annotation is needed to make this a field of [KotlinClass]. If the declaration is a non-primitive/non-String, use @JvmField instead
        const val dog: Int = 1

        //This will be treated as a member of the [Companion] object only. It generates the getter/setters for it.
        var bar: Int = 2

        //We can still use [@JvmStatic] for 'var' variables, but it generates getter/setters as functions of KotlinClass
        //If we use 'val' instead, it only generates a getter function
        @JvmStatic
        var cat: Int = 9
    }
}