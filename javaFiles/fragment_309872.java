jar {
    manifest {
        attributes(
                'Main-Class': 'bikesys.hda.BikeSys'
        )
    }
    from {
        configurations.compileClasspath.filter{ it.exists() }.collect { it.isDirectory() ? it : zipTree(it) }
    }
}