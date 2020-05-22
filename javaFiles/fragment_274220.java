public static File getWorkingDirectory(String applicationName) {
    File workingDirectory = new File("." + File.separator + applicationName);
    if ((!workingDirectory.exists()) && (!workingDirectory.mkdirs())) 
        throw new RuntimeException("The working directory could not be created: " + workingDirectory);
    return workingDirectory;
}