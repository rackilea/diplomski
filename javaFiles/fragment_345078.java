buildscript {
    ext {
        springBootVersion = '1.2.2.RELEASE'
        springLoadedVersion = "1.2.1.RELEASE"
    }
    repositories {
        mavenCentral()
        mavenLocal()
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath("org.springframework:springloaded:${springLoadedVersion}")
        classpath 'com.bluepapa32:gradle-watch-plugin:0.1.5'
    }
}

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

apply plugin: "java"
apply plugin: "spring-boot"
apply plugin: 'idea'
apply plugin: 'application'
apply plugin: 'com.bluepapa32.watch'


mainClassName = "com.example.my.Application"

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    runtime("org.hsqldb:hsqldb")
}

task wrapper(type: Wrapper) { gradleVersion = '2.3' }

idea {
    module {
        inheritOutputDirs = false
        outputDir = new File("$buildDir/classes/main/")
    }
}

compileJava {
    //enable compilation in a separate daemon process
    options.fork = true
    //enable incremental compilation
    options.incremental = true
}

watch {
    java {
        files files('src/main/java')
        tasks 'compileJava'
    }
}