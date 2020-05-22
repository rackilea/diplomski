apply plugin: 'java'

repositories {
    mavenCentral()
}

dependencies {
    compile 'com.google.apis:google-api-services-youtube:v3-rev79-1.17.0-rc'
    compile 'com.google.api-client:google-api-client:1.17.0-rc'
    compile 'com.google.http-client:google-http-client-gson:1.17.0-rc'
}