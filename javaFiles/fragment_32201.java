buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'org.javafxports:jfxmobile-plugin:1.3.2'
    }
}

apply plugin: 'org.javafxports.jfxmobile'

repositories {
    jcenter()
    maven {
        url 'http://nexus.gluonhq.com/nexus/content/repositories/releases'
    }
}

mainClassName = 'com.gluonhq.magnetometer.TestMagnetometer'

dependencies {
    compile 'com.gluonhq:charm:4.3.0'
}

jfxmobile {
    downConfig {
        version = '3.2.0'
        plugins 'display', 'lifecycle', 'magnetometer', 'statusbar', 'storage'
    }
    android {
        manifest = 'src/android/AndroidManifest.xml'
    }
    ios {
        infoPList = file('src/ios/Default-Info.plist')
        forceLinkClasses = [
                'com.gluonhq.**.*',
                'javax.annotations.**.*',
                'javax.inject.**.*',
                'javax.json.**.*',
                'org.glassfish.json.**.*'
        ]
    }
}