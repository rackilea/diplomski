buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        // see https://jcenter.bintray.com/com/android/tools/build/gradle/
        classpath 'com.android.tools.build:gradle:2.1.0'
        // classpath 'com.android.tools.build:gradle:2.2.0-alpha1'

        // https://github.com/palantir/gradle-jacoco-coverage
        classpath 'com.palantir:jacoco-coverage:0.4.0'      
    }
}

// https://github.com/palantir/gradle-jacoco-coverage
apply plugin: 'com.palantir.jacoco-full-report'