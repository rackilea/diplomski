public void importBuild(Object antBuildFile, Transformer<? extends String, ? super String> taskNamer) {
    File file = this.gradleProject.file(antBuildFile);
    File baseDir = file.getParentFile();

    Set existingAntTargets = new HashSet(getAntProject().getTargets().keySet());
    File oldBaseDir = getAntProject().getBaseDir();
    getAntProject().setBaseDir(baseDir);