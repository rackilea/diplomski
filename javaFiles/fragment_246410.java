jar {
    doLast {
        project.exec {
            workingDir destinationDirectory.get()
            executable 'jar'
            args '--update'
            args '--file', archiveFileName.get()
            args '--main-class', mainClassName
            args '.'
        }
    }
}