/*
 * perform Gradle tasks such as compile, build, test
 */
public static void performGradleTasks(String path, String ... tasks)
{
    GradleConnector connector = GradleConnector.newConnector();

    connector.forProjectDirectory(new File(path));

    ProjectConnection connection = connector.connect();
    try {
        // Configure the build
        BuildLauncher launcher = connection.newBuild();
        launcher.forTasks(tasks);
        launcher.setStandardOutput(System.out);
        launcher.setStandardError(System.err);

        // Run the build
        launcher.run();
    } finally {
        // Clean up
        connection.close();
    }
}