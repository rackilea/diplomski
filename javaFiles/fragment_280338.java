apply plugin: 'java'
apply plugin: 'maven'
apply plugin: 'spring-boot'

group = 'uptake'
version = '0.0.1-snapshot'

description = """Spring-Boot-ReceiverAPI"""

sourceCompatibility = 1.8
targetCompatibility = 1.8
tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'org.springframework.boot:spring-boot-gradle-plugin:1.4.1.RELEASE'
    }
}

repositories {
     maven { url "http://repo.maven.apache.org/maven2" }
}

dependencies {
    compile 'org.springframework.boot:spring-boot-starter'
    compile 'org.springframework.boot:spring-boot-starter-logging'
    compile 'org.springframework.boot:spring-boot-starter-web'
    compile 'org.springframework.boot:spring-boot-starter-data-jpa'
    compile 'org.postgresql:postgresql'
    compile 'com.fasterxml.jackson.datatype:jackson-datatype-hibernate4'
    compile 'com.fasterxml.jackson.core:jackson-core'
    compile 'org.apache.kafka:kafka_2.10:0.9.0.0'
    compile 'org.springframework.integration:spring-integration-kafka:2.0.1.RELEASE'
    compile 'org.apache.zookeeper:zookeeper:3.4.5'
    compile 'commons-beanutils:commons-beanutils'
    compile 'org.json:json'
    compile 'org.codehaus.jackson:jackson-mapper-asl:1.5.0'
    compile 'org.springframework:spring-core'
    compile 'com.spotify:docker-maven-plugin:0.4.13'
}

configurations.all {
    exclude module: 'slf4j-log4j12'
    exclude module: 'jms'
    exclude module: 'jmxtools'
    exclude module: 'jmxri'
}