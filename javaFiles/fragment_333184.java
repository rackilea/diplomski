buildscript {
    repositories {
        mavenCentral()
        maven { url 'https://repo.spring.io/milestone' }
    }
    dependencies {
        classpath 'org.springframework.boot:spring-boot-gradle-plugin:2.1.0.RC1'
    }
}

apply plugin: 'java'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

sourceCompatibility = 10 // eclipse has (or had) problems with Java 11
targetCompatibility = 10

sourceSets {
    // 'java' plugin adds default main sourceSet
    dev {
        resources.srcDirs = [
            project(':front').projectDir.absolutePath + '/src-client',
            project(':front').buildDir.absolutePath + '/dev'
        ]
    }
}

bootJar {
    baseName 'application'
    classifier 'SNAPSHOT-' + new Date().format('yyyyMMddHHmmssSSS')
    // I used bootArchives since it was already there and my stuff fits description, you can also define your own configuration and extend runtime one.
    classpath configurations.bootArchives
}

bootRun {
    sourceResources sourceSets.dev // I make bootRun (dev) use dev sourceSet
}

dependencies {
    runtime 'org.springframework.boot:spring-boot-devtools'
    // Since bootArchives configuration is used only by bootJar (not bootRun), this will be only in final fat .jar
    bootArchives project(':front')
    ...
}

repositories {
    mavenCentral()
    maven { url 'https://repo.spring.io/milestone' }
}