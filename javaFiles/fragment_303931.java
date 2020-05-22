buildscript {
    repositories {
        maven { url "https://jitpack.io" }
        jcenter()
        google()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.1.2'
    }
}

allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
        jcenter()
        google()
    }
}