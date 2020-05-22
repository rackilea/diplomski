wrapInstructions {
    printManifests = true
    manifest( 'aopalliance.*' ) {
        instruction 'Export-Package', '*;version=1.0'
    }
}