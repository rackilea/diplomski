public void run(IProgressMonitor monitor) {
    monitor.beginTask("Task", 1+20);
    try {
        monitor.subTask("Initializing");
        final List<Object> list = retrieveList();
        monitor.worked(1);

        IProgressMonitor sub = new SubProgressMonitor(monitor, 20);
        sub.beginTask("", list.size());
        for (Object o : list) {
            sub.subTask(""+o);
            // ...
            sub.worked(1);
        }
        sub.done();
    } finally {
        monitor.done();
    }
}