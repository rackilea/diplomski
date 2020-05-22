buildscript {
    // ...
    dependencies {
        // ...
        classpath 'com.google.gms:google-services:3.1.0' // google-services plugin
    }
}

allprojects {
    // ...
    repositories {
        jcenter()
        maven {
            url "https://maven.google.com" // Google's Maven repository
        }
    }
}