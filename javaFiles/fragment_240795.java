IToolBarManager toolBarManager = actionBars.getToolBarManager();
toolBarManager.add(new ControlContribution("Toggle Chart") {
    @Override
    protected Control createControl(Composite parent)
    {
        Button button = new Button(parent, SWT.PUSH);
        button.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
                // Perform action
            }
        });
     }
});