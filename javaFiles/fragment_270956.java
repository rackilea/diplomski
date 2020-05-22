public boolean build(String ...tasks) {
    ProjectConnection connection = connector.connect();
    BuildLauncher build = connection.newBuild();
    if (tasks.length > 0) {
        build.forTasks(tasks);
    }

    try {
        build.run();
    }finally {
        connection.close();
    }
    return true;
}