public class IMethodFinder {
    public IMethodFinder(String projectName, String methodName,
        int numberOfParameters) {
        this(createProject(projectName), methodName, numberOfParameters);
    }

    public IMethodFinder(IJavaProject javaProject, String methodName,
        int numberOfParameters) {
        ... 
    }

    private static IJavaProject createProject(String projectName) {
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        IJavaProject javaProject = JavaCore.create(project);
        return javaProject;
    }
}