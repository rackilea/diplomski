task allMethods(dependsOn: classes) << {
    def ncl = new GroovyClassLoader()
    ncl.addClasspath("${sourceSets.main.output.classesDir}")
    configurations.compile.each { ncl.addClasspath(it.path) }
    def cTree = fileTree(dir: sourceSets.main.output.classesDir)
    def cFiles = cTree.matching {
        include '**/*.class'
        exclude '**/*$*.class'
    }
    cFiles.each { f ->
        def c = f.path - (sourceSets.main.output.classesDir.path + "/")
        def cname = c.replaceAll('/', '\\.') - ".class"
        def cz = Class.forName(cname, false, ncl)
        cz.methods.each { println it }
    }
}