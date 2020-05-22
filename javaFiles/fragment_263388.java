buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath 'org.javafxports:jfxmobile-plugin:1.0.0-b10'
    }
}

apply plugin: 'org.javafxports.jfxmobile'

mainClassName = 'com.julioqc.superflush.Main'

repositories {
    jcenter()
}

jfxmobile {
    ios {
        forceLinkClasses = ['com.julioqc.superflush.**.*']
    }
    android {
        androidSdk = 'C:/Users/<user>/AppData/Local/Android/android-sdk'
    }
}