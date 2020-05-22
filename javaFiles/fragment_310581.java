// Make sure we've parsed sub-project dependencies
evaluationDependsOnChildren()
// Map of all projects by name
def subProjectsByName = subprojects.collectEntries { p -> [p.name, p] }

// Replace artifact dependencies with subproject dependencies, if possible
subprojects.each { p ->
    def changes = [] // defer so we don't get ConcurrentModificationExceptions
    p.configurations.each { c ->
        c.dependencies.each { d ->
            def sub = subProjectsByName[d.name]
            if (sub != null) {
                changes.add({
                    c.dependencies.remove(d)
                    p.dependencies.add(c.name, sub)
                })
            }
        }
    }
    for (change in changes) {
        change()
    }
}

task wrapper(type: Wrapper) {
    gradleVersion = '2.3'
}