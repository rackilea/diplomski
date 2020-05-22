repositories {
    mavenCentral()
    maven {
        url "http://maven.openimaj.org"
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:18.+'
    compile('org.openimaj:image-processing:1.3.1') {
        exclude group: 'org.apache.xmlgraphics'
        exclude group: 'xml-apis'
    }
}