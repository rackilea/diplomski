Button[][] buttonArray = new Button[4][4];
TableLayout table = new TableLayout(context);
for (int row = 0; row < 4; row++) {
    TableRow currentRow = new TableRow(context);
    for (int button = 0; button < 4; button++) {
        Button currentButton = new Button(context);
        // you could initialize them here
        currentButton.setOnClickListener(listener);
        // you can store them
        buttonArray[row][button] = currentButton;
        // and you have to add them to the TableRow
        currentRow.addView(currentButton);
    }
    // a new row has been constructed -> add to table
    table.addView(currentRow);
}
// and finally takes that new table and add it to your layout.
layoutVertical.addView(table);