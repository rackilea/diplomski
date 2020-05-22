configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute module("com.company:lib") with project(":lib")
        substitute module("com.company:lib2") with project(":lib2")
    }
}