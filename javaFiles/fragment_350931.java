if (task.getStatus() == AsyncTask.Status.FINISHED) {
    task = new AsyncTask();
}

if (task.getStatus() != AsyncTask.Status.RUNNING) {
    task.execute();
}