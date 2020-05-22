javadoc {
    source = sourceSets.main.allJava
    options.docletpath = configurations.umlDoclet.files.asType(List)
    options.doclet = "nl.talsmasoftware.umldoclet.UMLDoclet"
}

task generateUmlClass(type: Javadoc) {
    dependsOn("javadoc")
    source = sourceSets.main.allJava
    destinationDir = reporting.file("uml")
    options.docletpath = configurations.umlDoclet.files.asType(List)
    options.doclet = "nl.talsmasoftware.umldoclet.UMLDoclet"
}