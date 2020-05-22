plugins {
    id 'org.springframework.boot' version '2.2.2.RELEASE'
    id 'io.spring.dependency-management' version '1.0.8.RELEASE'
    id 'java'
    id 'com.google.protobuf' version '0.8.10'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'com.google.protobuf:protobuf-java:3.11.1'
    testImplementation('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
}

test {
    useJUnitPlatform()
}

sourceSets {
    main {
        proto {
            srcDir 'src/main/proto'
        }
        java {
            // include self written and generated code
            srcDirs 'src/main/java', 'generated-sources/main/java'
        }
    }
    // remove the test configuration - at least in your example you don't have a special test proto file
}

protobuf {
    // Configure the protoc executable
    protoc {
        // Download from repositories
        artifact = 'com.google.protobuf:protoc:3.6.0'
    }

    generateProtoTasks.generatedFilesBaseDir = 'generated-sources'

    generateProtoTasks {
        // all() returns the collection of all protoc tasks
        all().each { task ->
            // Here you can configure the task
        }

        // In addition to all(), you may get the task collection by various
        // criteria:

        // (Java only) returns tasks for a sourceSet
        ofSourceSet('main')

    }
}