@Override
protected Control createDialogArea(Composite parent) {
    container = (Composite) super.createDialogArea(parent);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
    GridLayoutFactory.fillDefaults().numColumns(2).margins(5, 5).applyTo(container);

    Group group = new Group(container, SWT.NONE);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,  false).applyTo(group);
    GridLayoutFactory.fillDefaults().applyTo(group);        
    for (M_ATTRIBUTE attr : M_ATTRIBUTE.values()) {
        Button button = new Button(group, SWT.CHECK);
        GridDataFactory.fillDefaults().applyTo(button);
        button.setText(attr.getDisplayValue());
        this.buttons.put(attr, button);
    }
    stack = new Composite(container, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(stack);
    stackLayout = new StackLayout();
    stack.setLayout(stackLayout);               
    compMultiLine = new Composite(stack, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(compMultiLine);
    GridLayoutFactory.fillDefaults().applyTo(compMultiLine);
    valueTextMulti = new Text(compMultiLine, SWT.BORDER | SWT.MULTI |SWT.WRAP);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(valueTextMulti);
    valueTextMulti.addModifyListener(valueTextModifyListener);              
    compSingleLine = new Composite(stack, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(compSingleLine);
    GridLayoutFactory.fillDefaults().applyTo(compSingleLine);
    valueTextSingle = new Text(compSingleLine, SWT.BORDER | SWT.SINGLE | SWT.WRAP);
    GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.TOP).applyTo(valueTextSingle);
    valueTextSingle.addModifyListener(valueTextModifyListener);         
    stackLayout.topControl = compMultiLine;
    return container;
}


@Override
public void selectionChanged(SelectionChangedEvent event) {
    IStructuredSelection sel = (IStructuredSelection) event.getSelection();
    M_DATA_TYPE type = (M_DATA_TYPE) sel.getFirstElement();
    switch (type) {
    case LIST:
    case HASH_TABLE:
        stackLayout.topControl = compMultiLine;
        stack.layout();
        break;
    default:
        stackLayout.topControl = compSingleLine;
        stack.layout();
        break;
    }
}