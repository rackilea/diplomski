public void elementChanged(ElementChangedEvent event) {

   ... code not run in UI thread

   Display.getDefault().asyncExec(() ->
     {
       ... code to run in UI thread
     });
}