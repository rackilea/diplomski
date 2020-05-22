display = Display.getDefault();
shell = new Shell(display, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
//Shell shell = window.getShell();
NSWindow nswindow = shell.view.window();
nswindow.setCollectionBehavior(0);  
nswindow.setShowsResizeIndicator(false);
setDialogShell(shell);
getDialogShell().setLayout( new FormLayout());
getDialogShell().setFullScreen(false);