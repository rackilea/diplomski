plugins {
   id 'java'
   id 'maven-publish'
}

repositories {
    mavenLocal()
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

sourceSets {
    main {
        java { srcDir 'src/main/java' }
        resources {
            srcDirs 'src/main/resources'
        }
    }

    test {
        java { srcDir 'src/test/java' }
        resources {
            srcDirs 'src/test/resources'
        }
    }


}

publishing {
        publications {
            maven(MavenPublication) {
                groupId = 'org.gradle.sample'
                artifactId = 'project1-sample'
                version = '1.1'

                from components.java
            }
        }
    }