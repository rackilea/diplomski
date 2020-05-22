class DynamicDeps implements Plugin<Project> {
    @Override
    void apply(Project target) {
        target.dependencies.add("implementation", target.rootProject.project("myUiModule"), { dep -> 
            dep.transitive = false
        })
        target.dependencies.add("runtimeOnly", target.rootProject.project("myBusinessLogicModule"), { dep -> 
            dep.transitive = false
        })
    }
}

apply plugin: DynamicDeps