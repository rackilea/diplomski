this.fileListTable.addSelectionListener(new SelectionListener() {

    @Override
    public void widgetDefaultSelected(SelectionEvent e) {
        // Nothing to do
    }

    @Override
    public void widgetSelected(SelectionEvent e) {

        int selectionIndex = fileListTable.getSelectionIndex();                                                             
        TableItem[] items = fileListTable.getItems();
        TableItem newItem;
        for (int i = 0; i < items.length; i++) {
        String first = items[i].getText(0);
        String second = items[i].getText(1);
        String third = items[i].getText(2);
        items[i].dispose();
        newItem = new TableItem(fileListTable, SWT.NONE);
        newItem.setText(new String[] { first, second, third });
        if (i == selectionIndex) {
            newItem.setForeground(soureWindow.getSelectionForeground());//Or Anyother color
            newItem.setBackground(soureWindow.getSelectionBackground());//Or Anyother color
        } else {
            newItem.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));//Default foreground color
            newItem.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));//Default background color
        }
        }                
    }
    });