public static boolean addReport(Report report, Context context) {
    context.runUnelevated(new RemoteCallable() {
        @Override
        public Serializable execute() {
             InvestigatorReport.reports.add(report);
             return null;
        }
    });
}