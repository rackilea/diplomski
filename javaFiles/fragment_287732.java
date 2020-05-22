apply plugin: 'java'
apply plugin: "net.ltgt.apt"
apply plugin: "idea"

task cleanGenerated(type: Delete) {
    delete 'build'
}

clean.dependsOn cleanGenerated


dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])

    // Force Java 7 as newer versions can not be processed by dex for API 21
    targetCompatibility = '1.7'
    sourceCompatibility = '1.7'

    [...]

    // Dagger for dependency injection
    compile 'com.google.dagger:dagger:2.8'
    apt 'com.google.dagger:dagger-compiler:2.8'
    testCompile 'com.google.dagger:dagger:2.8'
    testApt 'com.google.dagger:dagger-compiler:2.8'

    [...]

    testCompile 'junit:junit:4.12'

}