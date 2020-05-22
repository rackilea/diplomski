apply plugin: 'java'
apply plugin: 'application'

repositories {
    jcenter()
}

dependencies {
    runtime group: 'org.apache.commons', name: 'commons-lang3', version: '3.6'
}

mainClassName = 'net.codetojoy.App'