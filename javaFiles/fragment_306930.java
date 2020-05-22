final TableLayout layout = (TableLayout) findViewById(R.id.tableLayout);

for(int i=0; i<items.size(); i++) {

    Item item = items.get(i);

    final TableRow row = new TableRow(this);
    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
    row.setLayoutParams(lp);

    TextView name = new TextView(this);
    TextView price = new TextView(this);
    Button delete = new Button(this);
    delete.setText("Delete");
    delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            layout.removeView(row);
        }
    });

    name.setText(item.getName());
    price.setText(Double.toString(item.getPrice()));
    row.addView(name);
    row.addView(price);
    row.addView(delete);

    layout.addView(row, i);
}