parent.setLayout( new GridLayout() );

Button upper = new Button( parent, SWT.PUSH );
GridData upperData = new GridData( SWT.FILL, SWT.TOP, true, false );
upperData.heightHint = 500;
upper.setLayoutData( upperData );

Button lower = new Button( parent, SWT.PUSH );
GridData lowerData = new GridData( SWT.FILL, SWT.FILL, true, true );
lower.setLayoutData( lowerData );