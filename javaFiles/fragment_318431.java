new AntBuilder ().with {
    compileClasspath = path(id: "compile.classpath") {
        fileset(dir: "libs") {
            include(name: "**/*.jar")
        } 
    }

    // print the classpath entries to System.out
    compileClasspath.list().each { println it }

    javac (...) {
        classpath (refid: "compile.classpath")
    }
}