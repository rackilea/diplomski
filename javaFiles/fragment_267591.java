final Composite area = new Composite(parent, SWT.NULL);
final GridLayout gridLayout = new GridLayout();

mTextWidget = new Text(area, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);

// Define a minimum width
final GridData gridData = new GridData();
gridData.widthHint = DEFAULT_WIDTH;
gridData.heightHint = DEFAULT_HEIGHT;
mTextWidget.setLayoutData(gridData);