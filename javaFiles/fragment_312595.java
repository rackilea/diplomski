@file:JvmName("KotlinClass")

//This provides a name for this file, so it's not defaulted as [KotlinClassKt] in Java
package com.frybits

object KotlinClass { //No need for the 'class' keyword here.

    //Direct access to this variable
    const val foo: Int = 1

    //Tells Java this can be accessed directly from [KotlinClass]
    @JvmStatic
    var cat: Int = 9

    //Just a function that returns the class name
    @JvmStatic
    fun getCustomClassName(): String = this::class.java.simpleName + "boo!"

    //Getter/Setter access to this variable, but isn't accessible directly from [KotlinClass]
    var bar: Int = 2

    fun someOtherFunction() = "What is 'INSTANCE'?"
}