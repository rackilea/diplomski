public class MainActivity extends AppCompatActivity {
Button btn;
TableLayout table;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.button);
    table = (TableLayout) findViewById(R.id.ourTableLayout);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TableRow newRow = new TableRow(MainActivity.this);
            TextView barCode = new TextView(MainActivity.this);
            TextView itemDesc = new TextView(MainActivity.this);
            TextView weightLine = new TextView(MainActivity.this);
            TextView rateAmount = new TextView(MainActivity.this);
            TextView makingAmount = new TextView(MainActivity.this);
            TextView netRate = new TextView(MainActivity.this);
            TextView total = new TextView(MainActivity.this);

            barCode.setText("Barcodes");
            itemDesc.setText("Descriptions");
            weightLine.setText("Weights");
            rateAmount.setText("Rates");
            makingAmount.setText("Makings");
            netRate.setText("Nets");
            total.setText("Totals");

            newRow.addView(barCode);
            newRow.addView(itemDesc);
            newRow.addView(weightLine);
            newRow.addView(rateAmount);
            newRow.addView(makingAmount);
            newRow.addView(netRate);
            newRow.addView(total);
            table.addView(newRow);

        }
    });
  }
}