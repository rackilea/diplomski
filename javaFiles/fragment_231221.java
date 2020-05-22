task packageJavadoc(type: Jar, dependsOn: 'javadoc') {
    from javadoc.destinationDir
    classifier = 'javadoc'
}
task packageSources(type: Jar, dependsOn: 'classes') {
    from sourceSets.main.allSource
    classifier = 'sources'
}
artifacts {
    archives packageJavadoc
    archives packageSources
}