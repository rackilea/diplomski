public static void imBusy(final boolean busy){

    Display.getDefault().asyncExec(new Runnable()
    {
        @Override
        public void run()
        {
            Shell shell = Display.getDefault().getActiveShell();
            if(busy){ //show Busy Cursor
                Cursor cursor = Display.getDefault().getSystemCursor(SWT.CURSOR_WAIT);          
                shell.setCursor(cursor);
            }else{  
                shell.setCursor(null);
            }   
        }
    });

}