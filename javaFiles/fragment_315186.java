IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

IViewReference [] viewRefs = page.getViewReferences();

for (IViewReference viewRef : viewRefs)
 {
   String id = viewRef.getId();

   ... use id in getSelection
 }