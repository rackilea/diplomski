This is How it started Working.

    @Override
protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);

 TableLayout table = new TableLayout(this);  
     table.setStretchAllColumns(true);
     table.setShrinkAllColumns(true);
     TableRow rowTitle = new TableRow(this);
     rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);
     TableRow.LayoutParams trparams = new   TableRow.LayoutParams(android.widget.TableRow.LayoutParams.WRAP_CONTENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT);
    rowTitle.setLayoutParams(trparams); 
    rowTitle.setGravity(Gravity.CENTER_HORIZONTAL); 
    TableRow rowDayLabels = new TableRow(this);
    TableRow rowAmounts = new TableRow(this);
    TextView empty = new TextView(this);
    empty.setText("Empty");
    TextView title = new TextView(this);
    title.setLayoutParams(trparams);
    table.setLayoutParams(trparams);
    title.setText("WikiCode");
    rowTitle.addView(title);
    rowTitle.addView(empty);
    table.addView(rowTitle);
    for(int i=0;i<4;i++)
    {   
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(trparams);
        for (int j = 0; j < 4; j++) {
            TextView number2 = new TextView(this);
            number2.setLayoutParams(trparams);               
            number2.setText("check"+i);                
            tableRow.addView(number2);
            tableRow.setGravity(Gravity.CENTER_HORIZONTAL);               
        }
        table.addView(tableRow);              
    }


    setContentView(table);
}