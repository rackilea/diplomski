@Action
public void myTaskButtonAction() { // this action is called from a menu item or a button
    startMyTaskAction();
}
@Action
public Task startMyTaskAction() { // this sets up the Task and TaskMonitor
    StartMyTask task = new StartMyTask(org.jdesktop.application.Application.getInstance());

    ApplicationContext C = getApplication().getContext();
    TaskMonitor M = C.getTaskMonitor();
    TaskService S = C.getTaskService();
    S.execute(task);
    M.setForegroundTask(task);

    return task;
}

private class StartMyTask extends Task<Void, Void> { // this is the Task
    StartMyTask(org.jdesktop.application.Application app) {
        super(app);
    }

    @Override
    protected Void doInBackground() {
        try {
            // specific code for your task
            // this code shows progress bar with status message for a few seconds
            setMessage("starting up");// status message
            for(int progress=0; progress<100; progress += (int)(Math.random()*10)) {
                setProgress(progress); // progress bar (0-100)
                setMessage("prog: "+progress); // status message
                try {
                    Thread.sleep((long)500); // sleep 500ms
                } catch (InterruptedException ignore) {
                }
            }
            setMessage("done");// status message
        }
        catch(java.lang.Exception e) {
            //specific code for exceptions
        }

        return null;
    }

    protected void succeeded() {
    }
}