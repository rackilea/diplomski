public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_main);

    String[] presidents = { "Dwight D. Eisenhower", "John F. Kennedy",
            "Lyndon B. Johnson", "Richard Nixon", "Gerald Ford",
            "Jimmy Carter", "Ronald Reagan", "George H. W. Bush",
            "Bill Clinton", "George W. Bush", "Barack Obama",
            "Dwight D. Eisenhower", "John F. Kennedy", "Lyndon B. Johnson",
            "Richard Nixon", "Gerald Ford", "Jimmy Carter",
            "Ronald Reagan", "George H. W. Bush", "Bill Clinton",
            "George W. Bush", "Barack Obama", "Dwight D. Eisenhower",
            "John F. Kennedy", "Lyndon B. Johnson", "Richard Nixon",
            "Gerald Ford", "Jimmy Carter", "Ronald Reagan",
            "George H. W. Bush", "Bill Clinton", "George W. Bush",
            "Barack Obama" };

    ScrollView scrollView = new ScrollView(this);

    TableLayout tableLayout = new TableLayout(this);

    for (int i = 0; i < presidents.length; i++) {

        TableRow tableRow = new TableRow(this);

        TextView tv = new TextView(this);

        tv.setPadding(10, 10, 10, 10);

        tv.setGravity(Gravity.CENTER);
        tv.setText(presidents[i]);

        tableRow.addView(tv);

        tableLayout.addView(tableRow);
        View v = new View(this);
        v.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, 1));
        v.setBackgroundColor(Color.rgb(51, 51, 51));
        tableLayout.addView(v);
    }

    scrollView.addView(tableLayout);

        setContentView(scrollView);

    }
}