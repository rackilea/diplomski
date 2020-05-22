val taskList = ArrayList<Task>()

eventPlanners.forEach { eventPlanner ->

    // ...

    compositeDisposable.add(wfmStorageDomain.saveTasks(taskList)

    // ...
}