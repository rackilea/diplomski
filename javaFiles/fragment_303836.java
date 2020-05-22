btnOpen.addSelectionListener(new SelectionAdapter() {       
        @Override
        public void widgetSelected(SelectionEvent e) {      

            Shell visual_shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN | SWT.MAX | SWT.ON_TOP);
            visual_shell.pack();

            // Set framework size.
            visual_shell.setSize(1010,600);
            visual_shell.open();

            while (!visual_shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
        }
    });