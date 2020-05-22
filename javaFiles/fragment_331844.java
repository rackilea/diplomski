clientJar {
    // ensure the client jar file is relatively self-contained, so add API class
    // Note: this is additive, so the client configuration class files are already in the jar
    from sourceSets.main.output.asFileTree.matching {
        include 'com/mycompany/package/path/api/**'
}