Job job = new Job("") {

    @Override
    protected IStatus run(IProgressMonitor monitor) {
        monitor.beginTask("Task..." -1);
        // do what i need to do (and doesn't bother my UI)
        return Status.OK_STATUS;
    }
};

job.setUser(true);
job.schedule();
job.addJobChangeListener(new JobChangeAdapter() {
    @Override
    public void done(IJobChangeEvent event) {
        new UIJob("") {

            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                // Update my UI
                monitor.beginTask("UI Task..." -1);
                return Status.OK_STATUS;
            }
        }.schedule();
        super.done(event);
    }
});