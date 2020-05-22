// 4) If the output directories exist, add them to the MavenProject's source directories
    if(getOutputDirectory().exists() && getOutputDirectory().isDirectory()) {

        final String canonicalPathToOutputDirectory = FileSystemUtilities.getCanonicalPath(getOutputDirectory());

        if(log.isDebugEnabled()) {
            log.debug("Adding existing JAXB outputDirectory [" + canonicalPathToOutputDirectory
                    + "] to Maven's sources.");
        }

        // Add the output Directory.
        getProject().addCompileSourceRoot(canonicalPathToOutputDirectory);
    }