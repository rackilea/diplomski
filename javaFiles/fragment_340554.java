plugins {
    id 'org.jetbrains.intellij' version '0.4.1' apply false
    id 'org.springframework.boot' version '2.1.3.RELEASE'
    id 'java'
}

/**
 *This is task for update Gradle wrapper version.
 */
task wrapper(type: Wrapper) {
    gradleVersion = '4.7'
    distributionUrl = "https://services.gradle.org/distributions/gradle-${gradleVersion}-all.zip"
}

apply plugin: 'io.spring.dependency-management'

group = 'com.test.spring.api'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
    mavenCentral()
}

allprojects {

configurations {
    developmentOnly
    runtimeClasspath {
        extendsFrom developmentOnly
    }
}

    repositories {
        mavenCentral()
    }
}

task unitTest(type: Test) {
    exclude '**/ApplicationTests/**'
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
    runtimeOnly 'mysql:mysql-connector-java'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    compile("org.springframework.boot:spring-boot-starter-data-rest")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile group: 'org.springframework.data', name: 'spring-data-rest-hal-browser', version: '3.0.8.RELEASE'
    compile("org.springframework.data:spring-data-rest-webmvc:3.1.5.RELEASE")
}

    tasks.withType(JavaCompile) {
        options.compilerArgs << "-Xlint:unchecked" << "-Xlint:deprecation"
    }

    tasks.withType(FindBugs) {
        ignoreFailures = true
        reports {
            html { enabled = true }
            xml.enabled = !html.enabled
        }
    }

    /**
     * Preparing for release build
     */
    task prepRelease() {
    }