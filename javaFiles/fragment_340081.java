apply plugin: 'groovy'

repositories {
    mavenCentral()
}

dependencies {
    compile 'org.codehaus.groovy:groovy-all:2.3.11'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.9.1'
    compile group: 'com.h2database', name: 'h2', version: '1.4.196'

    testCompile group: 'org.spockframework', name: 'spock-core', version: '1.1-groovy-2.4'

}
task copyDependencies(type: Copy) {
    from configurations.runtime
    into "lib"
}