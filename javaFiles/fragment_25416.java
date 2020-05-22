apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'org.springframework.boot'

repositories {
    mavenCentral()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web") {
        exclude module: "spring-boot-starter-tomcat"
    }
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-jetty''
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-actuator'
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-freemarker'

    compile group: 'org.springframework', name: 'spring-orm'

    compile group: 'mysql', name: 'mysql-connector-java'
    compile group: 'org.hibernate', name: 'hibernate-core'
    compile group: 'commons-validator', name: 'commons-validator', version: '1.5.1'
    compileTest group: 'org.springframework.boot', name: 'spring-boot-starter-test'
}

task wrapper(type: Wrapper) {
    gradleVersion = '3.3'
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.1.RELEASE")
    }
}

springBoot {
    executable = true
}

sourceCompatibility = 1.8
targetCompatibility = 1.8