Pom/Project properties

All elements in the pom.xml, can be referenced with the project. prefix. This list is just an example of some commonly used elements. (deprecated: {pom.} prefix)

    ${project.build.directory} results in the path to your "target" directory, this is the same as ${pom.project.build.directory}
    ${project.build.outputDirectory} results in the path to your "target/classes" directory
    ${project.name}refers to the name of the project (deprecated: ${pom.name} ).
    ${project.version} refers to the version of the project (deprecated: or ${pom.version}).
    ${project.build.finalName} refers to the final name of the file created when the built project is packaged