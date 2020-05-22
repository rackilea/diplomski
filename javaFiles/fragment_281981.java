@Component
private MavenProject project;

@SuppressWarnings("unchecked")
@Override
public void execute() throws MojoExecutionException {
    List<String> classpathElements = null;
    try {
        classpathElements = project.getCompileClasspathElements();
        List<URL> projectClasspathList = new ArrayList<URL>();
        for (String element : classpathElements) {
            try {
                projectClasspathList.add(new File(element).toURI().toURL());
            } catch (MalformedURLException e) {
                throw new MojoExecutionException(element + " is an invalid classpath element", e);
            }
        }

        URLClassLoader loader = new URLClassLoader(projectClasspathList.toArray(new URL[0]));
        // ... and now you can pass the above classloader to Reflections

    } catch (ClassNotFoundException e) {
        throw new MojoExecutionException(e.getMessage());
    } catch (DependencyResolutionRequiredException e) {
        new MojoExecutionException("Dependency resolution failed", e);
    }
}