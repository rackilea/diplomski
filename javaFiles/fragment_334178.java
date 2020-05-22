buildscript {
    ext.kotlin_version = '1.1.1'  //Add this line
    repositories {
        jcenter()
        google()
    }
    dependencies {

        classpath 'com.android.tools.build:gradle:3.1.0'
        classpath 'com.google.gms:google-services:3.2.0'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        google()
    }
}