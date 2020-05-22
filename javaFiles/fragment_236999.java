buildscript {
    ext {
        springBootVersion = '2.0.0.M7'
    }
    repositories {
        mavenCentral()
        maven { url "https://repo.spring.io/snapshot" }
        maven { url "https://repo.spring.io/milestone" }
        maven { url 'http://repo.spring.io/plugins-release' }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath 'io.spring.gradle:propdeps-plugin:0.0.9.RELEASE'
        classpath 'org.springframework:springloaded:1.2.6.RELEASE'
    }
}

ext {
    springBootVersion = '2.0.0.M7'
}
apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'groovy'
//apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'
apply plugin: 'propdeps'
apply plugin: 'propdeps-idea'

group = 'com.example.app'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
    maven { url "https://repo.spring.io/snapshot" }
    maven { url "https://repo.spring.io/milestone" }
}

configurations {
    includeInJar
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-data-jpa')
    compile('org.springframework.boot:spring-boot-starter-web')
    compile('org.springframework.boot:spring-boot-starter-groovy-templates')
    compile('org.codehaus.groovy:groovy')

    includeInJar("org.webjars:bootstrap:4.0.0")
    includeInJar("org.webjars:jquery:3.3.1")
    configurations.compile.extendsFrom(configurations.includeInJar)
}

idea {
    module {
        inheritOutputDirs = true
    }
}

jar {
    from configurations.includeInJar.collect { it.isDirectory() ? it : zipTree(it) }
}

compileJava.dependsOn(processResources)