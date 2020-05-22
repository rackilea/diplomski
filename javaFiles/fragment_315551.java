configurations.all {
  resolutionStrategy.eachDependency { DependencyResolveDetails details ->
    if (details.requested.group == "org.vulnerable.dependency"
        && details.requested.name == "dependency"
        && details.requested.version == "1.0") {
      details.useTarget("org.secure.dependency:dependency:1.1")
    }
  }
}