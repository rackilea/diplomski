buildscript {
    repositories {
        maven {
            mavenCentral()
            url uri('repo')
        }
    }
    dependencies {
        classpath group: 'net.hkj', name: 'gradle-task',
                  version: '1.0-SNAPSHOT'
    }
    dependencies {
        classpath 'com.google.firebase:firebase-admin:5.3.1'
    }
}

task greeting(type: net.hkj.UploadTask) {
}