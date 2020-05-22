tasks.withType<BootJar>().configureEach {
    enabled = true
    manifest {
        attributes(
            "Implementation-Title" to project.description,
            "Implementation-Version" to project.version
        )
    }
}