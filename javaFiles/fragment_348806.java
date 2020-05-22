display = Display.getDefault();
        shell = new Shell(display, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
         //Shell shell = window.getShell();


        if(!isWindows()){
            Field field = Control.class.getDeclaredField("view");
            Object /*NSView*/ view = field.get(shell);
            if (view != null)
            {
                Class<?> c = Class.forName("org.eclipse.swt.internal.cocoa.NSView");
                Object /*NSWindow*/ window = c.getDeclaredMethod("window").invoke(view);

                c = Class.forName("org.eclipse.swt.internal.cocoa.NSWindow");
                Method setCollectionBehavior = c.getDeclaredMethod(
                        "setCollectionBehavior", /*JVM.is64bit() ?*/ long.class /*: int.class*/);
                setCollectionBehavior.invoke(window,0);
            }
            //          NSWindow nswindow = shell.view.window();
            //          nswindow.setCollectionBehavior(0) ; 
            //          nswindow.setShowsResizeIndicator(false);
        }
        setDialogShell(shell);
        getDialogShell().setLayout( new FormLayout());
        getDialogShell().setFullScreen(false);

        getDialogShell().layout();
        getDialogShell().pack();