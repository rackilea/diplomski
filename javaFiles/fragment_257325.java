public class MyActivity extends AppCompatActivity {


    TableLayout tableEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        tableEdit = findViewById(R.id.tableEdit);

        TableRow headerrow = new TableRow(this);
        addTableHeader("Type", 175, headerrow, true);// send true if you want to add devider
        addTableHeader("Exp", 175, headerrow, false);// send false if you don't want to add devider
        headerrow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        tableEdit.addView(headerrow);


    }

    private void addTableHeader(String title, int colWidth, TableRow headerrow, boolean flag) {

        TextView textview = new TextView(this);
        textview.setText(title);
        textview.setLayoutParams(new android.widget.TableRow.LayoutParams(colWidth, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        headerrow.addView(textview);

        if (flag) {
            View v = new View(this);
            v.setLayoutParams(new TableRow.LayoutParams(3, TableRow.LayoutParams.MATCH_PARENT));
            v.setBackgroundColor(Color.RED);

             ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        params.leftMargin = 100;
        params.rightMargin = 200;

        v.setLayoutParams(params);
            headerrow.addView(v);

        }
    }

}