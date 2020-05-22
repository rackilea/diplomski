class RefreshJob extends WorkbenchJob
{
        public RefreshJob()
        {
            super("Refresh Job");   
            setSystem(true); // set to false to show progress to user
        }

        public IStatus runInUIThread(IProgressMonitor monitor)
        {
            monitor.beginTask("Refreshing", ProgressMonitor.UNKNOWN);
            m_viewer.refresh();
            monitor.done(); 
            return Status.OK_STATUS;
        };
}