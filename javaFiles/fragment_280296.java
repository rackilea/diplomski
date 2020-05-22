public class TableLayoutActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.table_layout);
    final TableLayout tableLayout = (TableLayout) findViewById(R.id.table);

    for (int i = 0; i < 5; i++) {
        // Creation row
        final TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

        // Creation textView
        final TextView text = new TextView(this);
        text.setText("Test" + i);
        text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

        // Creation  button
        final Button button = new Button(this);
        button.setText("Delete");
        button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TableRow parent = (TableRow) v.getParent();
                tableLayout.removeView(parent);
            }
        });

        tableRow.addView(text);
        tableRow.addView(button);

        tableLayout.addView(tableRow);
    }

}
}