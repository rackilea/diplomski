jar {
    into('META-INF') {
        from generatePomFileForMavenPublication
        rename { it.replace('pom-default.xml', 'pom.xml') }
    }
}