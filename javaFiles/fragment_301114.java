private Button browse;
   browse = new Button(outerGroup, SWT.PUSH);
        browse.setText("Browse ...");
        browse.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,0));
        browse.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(shell, SWT.NULL);
                String path = dialog.open();
                if (path != null) {
                    //do stuff with path
                }
            }

        });