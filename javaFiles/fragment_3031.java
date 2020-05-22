configurations {
    fatJar
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
    testImplementation group: 'junit', name: 'junit', version: '4.12'

    fatJar "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
}

task fatJar(type: Jar) {
    manifest {
        attributes 'Implementation-Title': 'rpi-sense-hat-lib',
                'Implementation-Version': version,
                'Main-Class': 'io.github.lunarwatcher.pi.sensehat.Tests'
    }
    baseName = project.name
    from {
        configurations.fatJar.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
    with jar
}