Composite dynamicDataComp = new Composite(parent, SWT.NONE);
    dynamicDataComp.setLayout(new GridLayout(3, true));
    dynamicDataComp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

Group group_incom = new Group(dynamicDataComp, SWT.NONE);
        group_incom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        group_incom.setLayout(new RowLayout());

//...