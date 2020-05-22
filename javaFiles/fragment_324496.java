// [EDIT] - 'afterEvaluate' NOK, use 'gradle.projectsEvaluated' instead (see comments)
// afterEvaluate {
gradle.projectsEvaluated {
    // include src from all dependent projects (compile dependency) in JaCoCo test report
    jacocoTestReport {
        // get all projects we have a (compile) dependency on
        def projs = configurations.compile.getAllDependencies().withType(ProjectDependency).collect{it.getDependencyProject()}
        projs.each {
            additionalSourceDirs files(it.sourceSets.main.java.srcDirs)
            additionalClassDirs files(it.sourceSets.main.output)
        }
    }
}