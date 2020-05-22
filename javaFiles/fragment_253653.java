for (int i=0; i<50; i++) {
    TableItem tableItem = new TableItem(membersTable, SWT.NONE);                    
    tableItem.setText(new String[] {"person "+i, "610610620", "100"});

    Button button = new Button(membersTable, SWT.CHECK);
    button.pack();
    TableEditor editor = new TableEditor(membersTable);
    editor.minimumWidth = button.getSize().x;
    editor.horizontalAlignment = SWT.CENTER;
    editor.setEditor(button, tableItem, 3);

    final int index = i; // Hold the row index here

    button.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            //how to know in which row is clicked the checkbox?
            System.out.println("Row selected: " + index);
            System.out.println("Participación Habitual: " + tableItem.getText(2));
        }
    });
}