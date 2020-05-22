task codeCoverage(type: JacocoReport) {
    executionData fileTree("${buildDir}/jacoco/").include("*.exec")

    //sourceSets it.sourceSets.main  <--- REPLACED WITH FOLLOWING LINES!!!
    sourceDirectories = it.sourceSets.main.java
    classDirectories = it.sourceSets.main.output.classesDirs

    reports {
        xml.enabled true
        html.enabled true
    }
}