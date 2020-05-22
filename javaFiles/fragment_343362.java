final Group group = new Group(parent, SWT.NONE);
group.setText("Details");

group.setLayout(new GridLayout(2, false));

Label label1 = new Label(group, SWT.NONE);
label1.setText("Label 1");

Text text1 = new Text(group, SWT.LEAD | SWT.BORDER);
text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

Label label2 = new Label(group, SWT.NONE);
label2.setText("Label 2");

Text text2 = new Text(group, SWT.LEAD | SWT.BORDER);
text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));