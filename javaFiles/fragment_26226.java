javadoc {
    source = sourceSets.main.allJava
    options.docletpath = configurations.umlDoclet.files.asType(List)
    options.doclet = "nl.talsmasoftware.umldoclet.UMLDoclet"
    destinationDir = reporting.file("uml")
}