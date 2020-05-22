final Combo descRef = desc;
final Combo nameRef = name;

nameRef.addSelectionListener(new SelectionAdapter() {
    public void widgetSelected(SelectionEvent e)
        descRef.select(nameRef.getSelectionIndex());
    }
});