// reference the table layout
TableLayout tbl = (TableLayout)findViewById(R.id.RHE);
// delcare a new row
TableRow newRow = new TableRow(this);
// add views to the row
newRow.addView(new TextView(this)); // you would actually want to set properties on this before adding it
// add the row to the table layout
tbl.addView(newRow);