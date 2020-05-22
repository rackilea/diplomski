Button button = new Button(parent , SWT.RADIO);
button.addSelectionListener(new SelectionAdapter(){
    @override
    public void widgetSelected(final SelectionEvent e){
        super.widgetSelected();
        if(button.getSelection()){
            //do your processing
        }
    }
});