apply plugin: 'java'

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependecies {
your dependencies
}   

jar {
    archiveName = 'Name.jar'

    manifest {
        attributes 'Main-Class': 'uk.co.cdl.Main',
                'Class-Path': configurations.runtime.files.collect { "lib/$it.name" }.join(' '),
                'Implementation-Version': project.version
    }

    from(configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }) {
        exclude 'what you want to get rid dependencies/directories/files' etc
    }
}