buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'me.tatarka:gradle-retrolambda:3.5.0'
        classpath 'com.android.tools.build:gradle:2.2.3'
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}