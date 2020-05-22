@file:JvmName("KotlinClass") //This provides a name for this file, so it's not defaulted as [KotlinClassKt] in Java
package com.frybits

class KotlinClass {
    companion object {

        //This annotation tells Java classes to treat this method as if it was a static to [KotlinClass]
        @JvmStatic
        fun foo(): Int = 1

        //Without it, you would have to use [KotlinClass.Companion.bar()] to use this method.
        fun bar(): Int = 2
    }
}