// build.gradle
apply plugin: 'java'
apply plugin: 'application'

sourceCompatibility = '1.8'
[compileJava, compileTestJava]*.options*.encoding = 'UTF-8'


mainClassName = 'sound.Main'

repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.10'
}

jar { manifest { attributes 'Main-Class': 'sound.Main' } }