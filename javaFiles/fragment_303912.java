repositories {
    mavenCentral()
    maven {
        name = myAppReleases
        url = 'http://myapp.artifactoryonline.com/myapp/first-server-releases'
    }
    maven {
        name = myAppSnapshots
        url = 'http://myapp.artifactoryonline.com/myapp/first-server-snapshots/'
    }
}