task toJar(type: Jar) {
    from file("$rootDir/externalClasses")
    destinationDir project.buildDir
    // print each included file for debug purpose
    eachFile { print "included file: $it" }
}