Listener ctrlAListener = new Listener() {
   public void handleEvent( Event event ) {
      if ( event.stateMask == SWT.CTRL && event.keyCode == 'a' ) {
         ((Text)event.widget).selectAll();
      }
   }
};