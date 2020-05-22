public void execute() throws MojoExecutionException {
    FileSetManager fileSetManager = new FileSetManager();
    for (String includedFile : fileSetManager.getIncludedFiles(fileset)) {
        getLog().info(fileset.getDirectory() + File.separator + includedFile);
    }
}