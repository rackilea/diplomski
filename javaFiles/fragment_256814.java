afterEvaluate {
    [JavaExec, Test].each {
        project.tasks.withType(it) {
            it.jvmArgs "--add-opens=java.base/java.lang=ALL-UNNAMED"
        }
    }
}