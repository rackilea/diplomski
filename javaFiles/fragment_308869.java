jar {
    manifest {
        attributes('Main-Class': 'lab2.jdbc.App')
    }
    from {
        configurations.compileClasspath.filter { it.exists() }.collect { it.isDirectory() ? it : zipTree(it) }
    }
}