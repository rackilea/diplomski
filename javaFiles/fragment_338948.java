class MyPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.repositories {
            maven {
                url project.Repo_GP_Internal
                credentials {
                    username project.Repo_GP_User
                }
            }
        }
    }
}