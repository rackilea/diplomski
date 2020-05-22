class StatusRoleContextReportTaskWrapper {
    private ReportTask;

    public StatusRoleContextReportTaskWrapper(ReportTask task) { ... }

    public Option[] getOptions() { /* return options based on role and status */ }

    public static StatusRoleContextReportTaskWrapper[] getWrapped(ReportTask[] tasks) {
        /* wrap tasks ... */
        return wrappedTasks;
    }
}