allprojects {

    apply plugin: 'maven-publish'

    publishing {
        repositories {
            maven {
                url  "${artifactory_contextUrl}/"+ (version.contains('SNAPSHOT') ? 'libs-snapshot-local' : 'libs-release-local')
                credentials {
                    username "${artifactory_user}"
                    password "${artifactory_password}"
                }
            }
        }
    }

    repositories {
        mavenLocal()

        maven {
            url "${artifactory_contextUrl}/libs-release"
            credentials {
                username "${artifactory_user}"
                password "${artifactory_password}"
            }
        }

        maven {
            url "${artifactory_contextUrl}/libs-snapshot"
            credentials {
                username "${artifactory_user}"
                password "${artifactory_password}"
            }
        }
    }
}