public IMethodFinder(String projectName, String methodName,
        int numberOfParameters) {
        this(
            JavaCore.create(
                ResourcesPlugin.getWorkspace().getRoot().getProject(projectName)
            ),
            methodName,
            numberOfParameters
        );
    }