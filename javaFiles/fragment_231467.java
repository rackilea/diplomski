plugins {
    id 'maven-publish'
    id 'java-platform'
}
subprojects {
    configurations {
        deployerJars
    }

    apply plugin: 'java'
    apply plugin: 'java-library'
}
publishing {
    publications {
        myPlatform(MavenPublication) {
            from components.javaPlatform
        }
    }
}