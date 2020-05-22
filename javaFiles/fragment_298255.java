jar {
    manifest {
        attributes("Implementation-Title": project.name,
                "Implementation-Version": version,
                "Main-Class": 'com.your.full.path.to.Main'
        )
    }
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
    from('src/main/resources/'){
        include('database.properties')
        into('')
    }
}

sourceSets {
    main {
        resources {
            srcDirs "src/main/resources", "src/main/configs"
        }
    }
}