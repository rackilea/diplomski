GridLayout gridLayout = new GridLayout(2, false);
shell.setLayout(gridLayout);

tree = new Tree(shell, SWT.CHECK | SWT.BORDER);
GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
tree.setLayoutData(data);

Text tips = new Text(shell, SWT.READ_ONLY);
tips.setText("Pick the files and nodes to refactor : ");
tips.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

oldFileViewer = new Text(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
oldFileViewer.setText("here is the old file viewer\t\t\t\t\t\t\t\t\t\n\n\n\n\n\n");
data = new GridData(SWT.FILL, SWT.FILL, false, false);
data.heightHint = 400;
oldFileViewer.setLayoutData(data);

newFileViewer = new Text(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
newFileViewer.setText("and here is the new file viewer\t\t\t\t\t\t\t\t\t\n\n\n\n\n\n");
data = new GridData(SWT.FILL, SWT.FILL, false, false);
data.heightHint = 400;
newFileViewer.setLayoutData(data);

Button ok = new Button(shell, SWT.PUSH);
ok.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));