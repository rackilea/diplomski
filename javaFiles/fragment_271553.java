buildscript {
    repositories {
        jcenter()
        }

    dependencies {
        classpath 'org.javafxports:javafxmobile-plugin:1.0.0-rc3'
    }
}

apply plugin: 'javafxmobile'

mainClassName='org.javafxports.android.MainJavaFX'

repositories {
    jcenter()
}

jfxmobile {
    android {
        applicationPackage = 'org.javafxports.android'
    }
}