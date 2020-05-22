/**
   * Directory in which to create the Java COM wrapper files. This directory
   * will be added to the Maven project's compile source directory list and
   * will therfore be auto-compiled when the Maven compile phase is run.
   * 
   * @parameter expression="${outputDirectory}"
   *            default-value="${project.build.directory}/generated-sources/com4j/java"
   */