public class IPEApplication implements IApplication {
      public Object start(IApplicationContext context) throws Exception {
        final Display display = PlatformUI.createDisplay();
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());  }
        // start workbench...
      }
    }

private class ShutdownHook extends Thread {
  @Override
  public void run() {
    try {
      final IWorkbench workbench = PlatformUI.getWorkbench();
      final Display display = PlatformUI.getWorkbench()
                                        .getDisplay();
      if (workbench != null && !workbench.isClosing()) {
        display.syncExec(new Runnable() {
          public void run() {
            IWorkbenchWindow [] workbenchWindows = 
                            workbench.getWorkbenchWindows();
            for(int i = 0;i < workbenchWindows.length;i++) {
              IWorkbenchWindow workbenchWindow =
                                        workbenchWindows[i];
              if (workbenchWindow == null) {
                // SIGTERM shutdown code must access
                // workbench using UI thread!!
              } else {


        IWorkbenchPage[] pages = workbenchWindow
                                       .getPages();
            for (int j = 0; j < pages.length; j++) {
              IEditorPart[] dirtyEditors = pages[j]
                                       .getDirtyEditors();
              for (int k = 0; k < dirtyEditors.length; k++) {
                dirtyEditors[k]
                         .doSave(new NullProgressMonitor());
              }
            }
          }
        }
      }
    });
    display.syncExec(new Runnable() {
      public void run() {
        workbench.close();
      }
    });
  }
} catch (IllegalStateException e) {
  // ignore
}

  }
}