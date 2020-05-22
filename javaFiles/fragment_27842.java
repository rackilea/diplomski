public void widgetSelected(SelectionEvent e) {

    Display.getDefault().asyncExec(() ->
       {
          ... code to call command
       });

    close();
}