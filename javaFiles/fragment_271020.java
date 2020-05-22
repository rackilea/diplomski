variant.javaCompile.doLast {
    // Find the android.jar and add to iajc classpath
    def androidSdk = android.adbExe.parent + "/../platforms/" + android.compileSdkVersion + "/android.jar"
    println 'Android SDK android.jar path: ' + androidSdk

    def iajcClasspath = androidSdk + ":" + configurations.compile.asPath
    configurations.compile.dependencies.each { dep ->
        if(dep.hasProperty("dependencyProject")) {
            iajcClasspath += ":" + dep.dependencyProject.buildDir + "/bundles/release/classes.jar"
        }
    }

    // handle aar dependencies pulled in by gradle (Android support library and etc)
    tree = fileTree(dir: "${project.buildDir}/exploded-bundles", include: '**/classes.jar')
    tree.each { jarFile ->
        iajcClasspath += ":" + jarFile
    }
        println 'Classpath for iajc: ' + iajcClasspath

        ant.taskdef( resource:"org/aspectj/tools/ant/taskdefs/aspectjTaskdefs.properties", classpath: configurations.ajc.asPath)