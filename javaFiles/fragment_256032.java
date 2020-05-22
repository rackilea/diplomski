Composite parentComposite = new Composite(parent, SWT.NONE);
parentComposite.setLayout(new GridLayout(3, true));
parentComposite.setLayoutData(gridData);

TableViewer tableViewer1 = new TableViewer(parentComposite, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
tableViewer1.getTable().setHeaderVisible(true);
tableViewer1.getTable().setLayout(new GridLayout(1,false));
tableViewer1.getTable().setLayoutData(new GridData(200,400));

createButtonComposite(parentComposite,SWT.NONE);

TableViewer tableViewer2= new TableViewer(parentComposite, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
tableViewer2.getTable().setHeaderVisible(true);
tableViewer2.getTable().setLayoutData(new GridData(200,400));