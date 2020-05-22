TableLayout ll = (TableLayout) findViewById(R.id.tableLayout);


for (int i = 0; i < 4; i++) {

    TableRow row= new TableRow(this);
    TableRow.LayoutParams lp = new  TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
    row.setLayoutParams(lp);
    //add your buttons and stuff
    ll.addView(row,i);
}
}