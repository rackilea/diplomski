public static String openNewShellDialog(Display display)
{
    final Shell shell = new Shell(display , SWT.APPLICATION_MODAL); 
    shell.setLayout(new GridLayout(1, false));
    System.out.println(display.getPrimaryMonitor().getClientArea());
    shell.setLocation(616, 500); //It seems the location is relative to the center of the Shell w.r.t client area
    shell.setSize(0,0);
    shell.setVisible(false);
    shell.open();

    FileDialog d = new FileDialog(shell);
    String s = d.open();

    shell.dispose (); 
    while (!shell.isDisposed ()) { 
        if (!display.readAndDispatch ()) display.sleep (); 
    } 

    return s;
}