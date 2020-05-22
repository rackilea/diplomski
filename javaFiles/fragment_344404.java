Composite composite = new Composite(parent, SWT.NONE);
Composite childrenComposite = new Composite(composite, SWT.NONE);
Control childrenChildrenControl = new Control(childrenComposite, SWT.NONE);
Control childrenControl = new Control(composite, SWT.NONE);

composite.layout(true, true);