public IStatus runInWorkspace(IProgressMonitor monitor) {
     ...... Unimportant stuff  

    MavenUpdateRequest request = new MavenUpdateRequest(projects, offline,forceUpdateDependencies);
    Map<String, IStatus> updateStatus = configurationManager.updateProjectConfiguration(request, updateConfiguration,
    cleanProjects, refreshFromLocal, monitor);


...... Unimportant stuff