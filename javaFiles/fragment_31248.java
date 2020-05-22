public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;

    final boolean switchPerpective = processPluginUpgrading();
    if (switchPerpective) {
        final IWorkbench workbench = PlatformUI.getWorkbench();
        new UIJob("Switching perspectives"){
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                try {
                    workbench.showPerspective(perspectiveId, workbench.getActiveWorkbenchWindow());
                } catch (WorkbenchException e) {
                    return new Status(IStatus.ERROR,PLUGIN_ID,"Error while switching perspectives", e);
                }
                return Status.OK_STATUS;
            }}
        .run(new NullProgressMonitor());
    }
}