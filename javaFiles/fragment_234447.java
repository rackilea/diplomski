buildscript {
    repositories {
        jcenter()
        mavenLocal()
        maven {
            url 'http://spoon.gforge.inria.fr/repositories/'
        }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.0'
        classpath group: 'fr.inria.gforge.spoon',
                name: 'spoon-gradle-plugin',
                version:'1.0-SNAPSHOT'
        // here you put your module dependency
        classpath group: 'com.craftman.spoonprocessor',
                name: 'customprocessor',
                version: '1.0_SNAPSHOT'
        classpath files('build/classes/main')


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

apply plugin: 'java'
apply plugin: 'spoon'

spoon {
    processors = ['com.craftman.spoonprocessor.CustomProcessor']
}