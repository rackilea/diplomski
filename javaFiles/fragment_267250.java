configurations.all {
    resolutionStrategy.dependencySubstitution {
        all { dependency ->
            if (! dependency.requested.version.endsWith('SNAPSHOT'))
                return
            if (subprojects.find { p ->p.name == dependency.requested.module })
                dependency.useTarget project(":" + dependency.requested.module)
        }
    }
}