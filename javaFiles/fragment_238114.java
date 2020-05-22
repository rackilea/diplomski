task extractDeps << {
    configurations.cppDependencies.resolvedConfiguration.resolvedArtifacts.each { artifact ->
        copy {
            from project.zipTree(artifact.getFile())
            into new File(project.buildDir, "DEP_DIR/" + artifact.name)
        }
    }
}