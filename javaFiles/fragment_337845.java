@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TableLayout table = new TableLayout(getApplicationContext());
        table.setStretchAllColumns(true);

        for (int i = 0; i<20; i++) {

            TableRow[] tableRow = new TableRow[20];
            tableRow[i] = new TableRow(getApplicationContext());
            tableRow[i].setGravity(Gravity.CENTER);

            TextView pos = new TextView(getApplicationContext());
            pos.setGravity(Gravity.LEFT);
            pos.setText(String.valueOf(i) + ". " + getName(i));

            TextView a = new TextView(getApplicationContext());
            a.setGravity(Gravity.LEFT);
            a.setText("2/9");

            TextView points = new TextView(getApplicationContext());
            points.setGravity(Gravity.LEFT);
            points.setText("2/9");

            tableRow[i].addView(pos);
            tableRow[i].addView(a);
            tableRow[i].addView(points);

            table.addView(tableRow[i]);
        }

        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        container.addView(table);
    }

    private String getName(int i) {

        if (i == 2) {
            return "Recooooooooooooooord";
        } else if (i == 3) {
            return "Recooooooord";
        }

        return "Fran";
    }