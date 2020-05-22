Shell parentShell = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
Shell myShell = new Shell (parentShell, SWT.SHELL_TRIM);
// Very important, generally parents must have a layout set to display children
myShell.setLayout (new FillLayout()); 
Browser browser = new Browser (myShell, SWT.NONE);
browser.setUrl (getLoginUrl());
myShell.layout();
myShell.open();