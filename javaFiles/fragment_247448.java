task fatjar(type: Jar) {
    manifest {
        attributes 'Main-Class': 'org.gr8ex.Hello'
    }
    from { 
        configurations
            .runtime
            .collect { it.isDirectory() ? it : zipTree(it) }
    }
    with jar
}