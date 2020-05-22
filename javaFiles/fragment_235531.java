jar {
    archiveName = 'Name.jar'

    manifest {
        attributes 'Main-Class': 'your.main.class',
                'Class-Path': configurations.runtime.files.collect { "lib/$it.name" }.join(' '),
                'Implementation-Version': project.version
    }

    from(configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }) {}
}