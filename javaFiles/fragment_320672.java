configurations.all {
    resolutionStrategy.eachDependency { DependencyResolveDetails details ->
        if (details.requested.name == 'log4j') {
            details.useTarget "org.slf4j:log4j-over-slf4j:1.7.5"
        }
}