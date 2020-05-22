task diagnostics {
    doLast {
        println project.plugins
        println project.tasks*.name
        println project.configurations
    }
}