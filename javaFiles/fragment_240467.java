public static URL[] buildProjectClasspathList(ArtifactReference artifactReference)  throws ArtifactResolutionException, MalformedURLException, DependencyResolutionRequiredException {

    List<URL> projectClasspathList = new ArrayList<URL>();

    // Load build class path
    if(classpathElementsCache == null) {
        Application.getLogger().debug("Compile Classpath Elements Cache was null; fetching update");
        classpathElementsCache = artifactReference.getMavenProject().getCompileClasspathElements();
    }

    for (String element : classpathElementsCache) {
        Application.getLogger().debug("Looking at compile classpath element (via MavenProject): " + element);
        Application.getLogger().debug("  Adding: " + element);
        projectClasspathList.add(new File(element).toURI().toURL());
    }

    // Load artifact(s) jars using resolver
    if(dependencyArtifactsCache == null) {
        Application.getLogger().debug("Dependency Artifacts Cache was null; fetching update");
        dependencyArtifactsCache =  artifactReference.getMavenProject().getDependencyArtifacts();
    }

    Application.getLogger().debug("Number of artifacts to resolve: "
            + dependencyArtifactsCache.size());

    for (Artifact unresolvedArtifact : dependencyArtifactsCache) {
        String artifactId = unresolvedArtifact.getArtifactId();

        if (!isArtifactResolutionRequired(unresolvedArtifact, artifactReference)) {
            Application.getLogger().debug("  Skipping: " + unresolvedArtifact.toString());
            continue;
        }

        org.eclipse.aether.artifact.Artifact aetherArtifact = new DefaultArtifact(
                unresolvedArtifact.getGroupId(),
                unresolvedArtifact.getArtifactId(),
                unresolvedArtifact.getClassifier(),
                unresolvedArtifact.getType(),
                unresolvedArtifact.getVersion());

        ArtifactRequest artifactRequest = new ArtifactRequest()
                .setRepositories(artifactReference.getRepositories())
                .setArtifact(aetherArtifact);

        // This takes time; minimizing what needs to be resolved is the goal of the specified dependency code block
        ArtifactResult resolutionResult = artifactReference.getRepoSystem()
                .resolveArtifact(artifactReference.getRepoSession(), artifactRequest);

        // The file should exist, but we never know.
        File file = resolutionResult.getArtifact().getFile();
        if (file == null || !file.exists()) {
            Application.getLogger().warn("Artifact " + artifactId +
                    " has no attached file. Its content will not be copied in the target model directory.");
            continue;
        }

        String jarPath = "jar:file:" + file.getAbsolutePath() + "!/";
        Application.getLogger().debug("Adding resolved artifact: " + file.getAbsolutePath());
        projectClasspathList.add(new URL(jarPath));
    }

    return projectClasspathList.toArray(new URL[]{});
}