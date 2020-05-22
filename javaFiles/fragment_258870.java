Shell myshell = new Shell(display, SWT.NONE);
GridLayout twoColumn = new GridLayout();
twoColumn.numColumns = 2;
myshell.setLayout(gl);

Group g1 = new Group(myshell, SWT.DEFAULT);
Group g2 = new Group(myshell, SWT.DEFAULT);

GridData twospan = new GridData(SWT.FILL, SWT.FILL,true,true);
twospan.horizontalSpan = 2;

Table t1 = new Table(myshell, SWT.DEFAULT);
t1.setLayoutData(twospan);