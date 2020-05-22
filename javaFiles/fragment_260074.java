buildscript {
    repositories {
        maven.url "http://repo.spring.io/snapshot"
        mavenCentral()
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.0.BUILD-SNAPSHOT")
    }
}