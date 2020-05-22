task fatJar(type: Jar) {
    manifest.attributes = jar.manifest.attributes
    includeEmptyDirs = jar.includeEmptyDirs
    baseName = project.name + '-fat'
    from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
}

jar {
    manifest {
        attributes 'Implementation-Title': 'My executable jar!',
                'Implementation-Version': version,
                'Main-Class': 'com.example.so.q39209051.Main'
    }
    includeEmptyDirs false
    dependsOn 'fatJar'
}