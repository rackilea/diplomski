@Inject
TasksRepository(@Remote TasksDataSource tasksRemoteDataSource,
        @Local TasksDataSource tasksLocalDataSource) {
    mTasksRemoteDataSource = tasksRemoteDataSource;
    mTasksLocalDataSource = tasksLocalDataSource;
}