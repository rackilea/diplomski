apply plugin: 'maven-publish'

ext {
    jarFileCreatedByAnt = file('my.jar')
    artifactoryUrl = 'http://localhost:4001/artifactory'
}

publishing {
    publications {
        mavenJava(MavenPublication) {
            groupId 'org.gradle.sample'
            artifactId 'pluginmanager'
            version '1.1'
            artifact jarFileCreatedByAnt
        }
    }
    repositories {
        maven {
            url artifactoryUrl
        }
    }
}