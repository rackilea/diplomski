buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
         classpath 'com.vanniktech:gradle-android-junit-jacoco-plugin:0.6.0'
    }
}

apply plugin: 'com.vanniktech.android.junit.jacoco'