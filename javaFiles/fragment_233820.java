public class MainActivity extends Activity {
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    getView();
}


    public TextView[] populateDays(int startDay) {
    TextView[] daysTextViewArr = new TextView[7]; 
    String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday" }; 
    for (int i = 0; i < 7; i++) {
        daysTextViewArr[i] = new TextView(this);
        int day = i + startDay;
        if (day > 6) {
            day = day - 7;
        }
        daysTextViewArr[i].setText(days[i]);
    }

    return daysTextViewArr;
}

public void getView() {
    TableRow[] tableRows = new TableRow[6];

    TextView[] days = new TextView[7];
    days = populateDays(0);
    TableLayout monthView = (TableLayout) findViewById(R.id.monthView);
    LinearLayout headerLayout = new LinearLayout(this);
    headerLayout.setBackgroundColor(Color.WHITE);
    LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT, 1f); // create the

    for (int i = 0; i < 6; i++) {
        tableRows[i] = new TableRow(this);

    }
    for (int i = 0; i < 6; i++) {
        tableRows[0].addView(days[i]);
    }

    monthView.setBackgroundColor(Color.BLUE);

    for (int i = 0; i < 6; i++) {
        monthView.addView(tableRows[i]);
    }
}
}