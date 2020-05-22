public class Highscores extends Activity {

    TableLayout table;
    TableRow rowHeader, row1, row2, row3, row4, row5, row6, row7, row8, row9, row10;
    TextView rank, percentage, score;
    Button btn1;    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscoresmain);

        TableLayout table = (TableLayout)findViewById(R.id.tableLayout);

        TextView rank = new TextView(this);
        rank.setText("RANK");
        TextView percentage = new TextView(this);
        percentage.setText("PERCENTAGE");
        TextView score = new TextView(this);
        score.setText("SCORE");

        TableRow rowHeader = new TableRow(this);

        rowHeader.addView(rank);  //Line 39
        rowHeader.addView(percentage);
        rowHeader.addView(score);

        Button btn1 = (Button)findViewById(R.id.homeBtn);

        table.addView(rowHeader);

        btn1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Highscores.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}