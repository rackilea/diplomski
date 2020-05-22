Shell shell = new Shell();

FillLayout fillLayout = new FillLayout();
fillLayout.marginHeight = 5;
fillLayout.marginWidth = 5;
shell.setLayout( fillLayout );

Composite outer = new Composite( shell, SWT.BORDER );
outer.setBackground( new Color( null, 207, 255, 206 ) ); // Green

FormLayout formLayout = new FormLayout();
formLayout.marginHeight = 5;
formLayout.marginWidth = 5;
formLayout.spacing = 5;
outer.setLayout( formLayout );

Composite innerLeft = new Composite( outer, SWT.BORDER );
innerLeft.setLayout( new GridLayout() );
innerLeft.setBackground( new Color( null, 232, 223, 255 ) ); // Blue

FormData fData = new FormData();
fData.top = new FormAttachment( 0 );
fData.left = new FormAttachment( 0 );
fData.right = new FormAttachment( 10 ); // Locks on 10% of the view
fData.bottom = new FormAttachment( 100 );
innerLeft.setLayoutData( fData );

Composite innerRight = new Composite( outer, SWT.BORDER );
innerRight.setLayout( fillLayout );
innerRight.setBackground( new Color( null, 255, 235, 223 ) ); // Orange

fData = new FormData();
fData.top = new FormAttachment( 0 );
fData.left = new FormAttachment( innerLeft );
fData.right = new FormAttachment( 100 );
fData.bottom = new FormAttachment( 100 );
innerRight.setLayoutData( fData );

shell.open();