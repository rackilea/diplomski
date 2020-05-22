task fatJar(type: Jar) {
    manifest {
        attributes 'Implementation-Title': 'rpi-sense-hat-lib',
                   'Implementation-Version': version,
                   'Main-Class': 'io.github.lunarwatcher.pi.sensehat.Tests'
    }
    baseName = project.name
    from {
        configurations.runtimeClasspath.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    }
    with jar
}