tasks.withType(Jar).all { Jar jar ->
    jar.doFirst {
        String jarType = jar.extension
        if(jar.classifier) jarType = jar.classifier
        String fileName = "project.properties"
        ant.propertyfile(file: "${jar.temporaryDir}/${fileName}") {
            entry(key: "PROJECT_GROUP", value: project.group)
            entry(key: "PROJECT_ARTIFACT", value: project.archivesBaseName)
            entry(key: "PROJECT_VERSION", value: project.version)
            entry(key: "PROJECT_BUILD_DATE", value: new Date())
            entry(key: "BUILD_NUMBER", value: hasProperty("teamcity") ? teamcity["build.number"] : "local")
        }
        String intoPath = "your/package/name/here/${project.name}/${jarType}"
        jar.from(jar.temporaryDir) {
            include fileName
            if(jar instanceof War) intoPath = "WEB-INF/classes/${intoPath}"
            into(intoPath)
        }
        println "\tCreated ${intoPath}/${fileName}"
    }
}