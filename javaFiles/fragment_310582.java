// find all sub-projects and include them
rootDir.eachFileRecurse {
    if (it.name == "build.gradle") {
        def projDir = it.parentFile
        if (projDir != rootDir) {
            include projDir.name
            project(":${projDir.name}").projectDir = projDir
        }
    }
}