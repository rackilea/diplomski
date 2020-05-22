buildscript {

    repositories {
        google()
        jcenter()
        maven { url 'https://maven.fabric.io/public' }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'
        classpath 'com.google.gms:google-services:4.0.1'
        classpath 'com.google.firebase:firebase-plugins:1.1.5'
        classpath 'io.fabric.tools:gradle:1.25.4'
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url "https://maven.google.com" // Google's Maven repository
        }
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    // Sdk and tools
    minSdkVersion = 19
    targetSdkVersion = 28
    compileSdkVersion = 28
    buildToolsVersion = '28.0.0'
    versionCode = 18
    versionName = '3.6.0'

    // App dependencies
    supportLibraryVersion = '28.0.0'
    ....
}