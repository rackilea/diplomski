if (checkTask != null) {
    checkTask.dependsOn(myTask);
} else {
    tasks.whenTaskAdded(task -> {
        if ("check".equals(task.getName())) {
            task.dependsOn(myTask);
         }
    });
}