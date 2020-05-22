initscript {
    repositories {
       jcenter()
    }

    dependencies {
        classpath 'org.jfrog.buildinfo:build-info-extractor-gradle:3.1.1'
    }
}

allprojects {
    apply plugin: org.jfrog.gradle.plugin.artifactory.ArtifactoryConfigurationsGradle2Plugin //Note the lack of quotation marks
    apply plugin: org.jfrog.gradle.plugin.artifactory.ArtifactoryPublicationsGradle2Plugin //Note the lack of quotation marks

    artifactory {
        contextUrl = "${artifactory_contextUrl}"
        publish {
            repository {
                repoKey = 'libs-release-local'
                username = "${artifactory_user}"
                password = "${artifactory_password}"
                maven = true
            }
        }
        resolve {
            repository {
                repoKey = 'libs-release'
                username = "${artifactory_user}"
                password = "${artifactory_password}"
                maven = true
            }
        }
    }   
}