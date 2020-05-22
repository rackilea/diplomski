jar {
    manifest {
        attributes(
                'Main-Class': 'com.swa.rm.pricing.reporting.ux.SaleMxReportingUI'
        )
    }
}

task fatJar(type: Jar) {
    manifest.from jar.manifest
    classifier = 'all'
    from {
        configurations.runtime.collect { it.isDirectory() ? it : zipTree(it) }
    } {
        exclude "META-INF/*.SF"
        exclude "META-INF/*.DSA"
        exclude "META-INF/*.RSA"
    }
    with jar
}