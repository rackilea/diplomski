apply plugin: 'java'

targetCompatibility = '1.7'
sourceCompatibility = '1.7'

test {
    testLogging {
        // Show that tests are run in the command-line output
        events 'passed'
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
}