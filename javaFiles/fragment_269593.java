buildscript {
    repositories {
        mavenCentral()

        //Only necessary when developing locally.
        mavenLocal()
    }

    dependencies {             

        classpath 'com.letz:example-plugin:1.0'
    }
}
apply plugin: 'example-plugin'