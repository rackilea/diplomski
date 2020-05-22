Combo lineHeight;

lineHeight = new Combo(parent, SWT.READ_ONLY | SWT.BORDER);

lineHeight.setLayoutData(new GridData(SWT.LEAD, SWT.CENTER, false, false));

String [] choices = {"1", "2", "3", "4"};

lineHeight.setItems(choices);

lineHeight.select(0);  // Select "1" by default