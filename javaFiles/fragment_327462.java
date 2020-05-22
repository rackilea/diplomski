task fatJar(type: Jar) {
    manifest {
        attributes 'Main-Class': 'eagleview.App'

    }

    from {
        configurations.compile.collect {
            it.isDirectory() ? it : zipTree(it)
        }
    } with jar
}