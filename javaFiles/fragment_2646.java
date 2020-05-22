public class q34800380 {
    public void grepLogMessages(String url, String message) throws SVNException {
        SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
        try {
            SvnLog log = svnOperationFactory.createLog();
            log.setSingleTarget(SvnTarget.fromURL(SVNURL.parseURIEncoded(url)));
            log.addRange(SvnRevisionRange.create(SVNRevision.create(0), SVNRevision.HEAD));
            log.setDiscoverChangedPaths(true);
            log.setReceiver(new GrepLogReceiver(message));
            log.run();
        } finally {
            svnOperationFactory.dispose();
        }
    }
    private class GrepLogReceiver implements ISvnObjectReceiver<SVNLogEntry> {
        private String message;
        public GrepLogReceiver(String message) {
            this.message = message; 
        }
        @Override
        public void receive(SvnTarget target, SVNLogEntry le) throws SVNException {
            if (le.getMessage() != null && le.getMessage().contains(message)) {
                System.out.println("rev #" + le.getRevision() + ": " + le.getMessage());
                Map<String, SVNLogEntryPath> cps = le.getChangedPaths();
                for (Map.Entry<String, SVNLogEntryPath> e : cps.entrySet()) {
                    SVNLogEntryPath lep = e.getValue();
                    System.out.println(lep.getType() + " " + lep.getPath());
                }
            }
        }
    }
}