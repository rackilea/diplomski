jar {
    manifest {
        attributes 'Main-Class': 'your.main.class'
    }
    from {
        exclude '**/module-info.class'
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}