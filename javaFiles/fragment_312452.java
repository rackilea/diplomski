buildscript {
    repositories {
        mavenCentral()
                        }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.2.3.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'maven'
apply plugin: 'spring-boot'
apply plugin: 'war'

repositories {
    mavenCentral()
}


dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
}

//bootRepackage {
//    mainClass = 'org.package.Application'
//    }

war {
    baseName = 'app'
    version =  '0.1-SNAPSHOT'
    manifest {
        attributes 'Main-Class': 'org.package.Application'
    }
}