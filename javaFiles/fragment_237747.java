buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.8.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'org.springframework.boot'

jar {
    baseName = 'gs-rest-service'
    version =  '0.1.0'
}

repositories {
    mavenCentral()
    maven {
        url 'https://repo.spring.io/libs-milestone'
    }
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile('org.springframework.boot:spring-boot-starter-test')
    compile("org.springframework.boot:spring-boot-starter-security")
    testCompile("org.springframework.security:spring-security-test")
    compile group: 'org.jdbi', name: 'jdbi', version: '2.4.2'
    compile group: 'com.h2database', name: 'h2', version: '1.3.148'
    compile group: 'org.springframework', name: 'spring-jdbc', version: '4.3.8.RELEASE'
}