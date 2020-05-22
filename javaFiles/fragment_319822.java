task copySubprojectLibs (dependsOn: subprojects.jar) << {
    files(subprojects.jar).each { 
        ant.copy(file: it.absolutePath, todir: "build/libs/lib")
    }
    ant.copy(todir: "build/libs/nosr/conf") {
        fileset(dir: "src/main/resources")
    }
}