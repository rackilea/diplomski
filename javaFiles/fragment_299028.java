WorkspaceJob job = new WorkspaceJob("jobname") {
    @Override
    public IStatus runInWorkspace(IProgressMonitor monitor)
            throws CoreException {
        // TODO add code here
        this.schedule(30000);
        return Status.OK_STATUS;
    }
};
job.schedule();