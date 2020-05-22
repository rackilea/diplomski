executeMojo(
    plugin(
        groupId("org.apache.maven.plugins"),
        artifactId("maven-dependency-plugin"),
        version("2.0")
    ),
    goal("copy-dependencies"),
    configuration(
        element(name("outputDirectory"), "${project.build.directory}/foo")
    ),
    executionEnvironment(
        mavenProject,
        mavenSession,
        pluginManager
    )
);