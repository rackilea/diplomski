group 'com.github.sitrakary'
version '0.1-SNAPSHOT'

apply plugin: 'java'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
    // add sonatype repository
    maven {
        url 'https://oss.sonatype.org/content/repositories/snapshots/'
    }
}

dependencies {
    compile group: 'com.github.sitrakary',  name:'unit-converter', version:'1.0-SNAPSHOT', changing: true

    testCompile group: 'junit', name: 'junit', version: '4.12'
}