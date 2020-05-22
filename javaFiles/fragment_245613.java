public String reportTaskList(ModelMap model) {
    ReportTask[] tasks = reportTaskService.getSome();
    model.add("reportTasks", StatusRoleContextReportTaskWrapper.getWrapped(tasks));

    return "taskListView";
}