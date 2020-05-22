buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:0.5.+'
    }
}
apply plugin: 'android'

dependencies {
    compile 'com.google.android.gms:play-services:3.1.36'
}

android {
    compileSdkVersion 17
    buildToolsVersion "17.0.0"

    defaultConfig {
        minSdkVersion 8
        targetSdkVersion 16
    }
}