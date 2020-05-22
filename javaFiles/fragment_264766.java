sourceSets {
    main {
        java {
            srcDirs(project(':shared').sourceSets.main.java)
        }
    }
}