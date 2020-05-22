public class MainActivity extends Activity
{


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String[] row = { "ROW1", "ROW2", "Row3", "Row4", "Row 5", "Row 6",
                         "Row 7"
                       };
        String[] column = { "COLUMN1", "COLUMN2", "COLUMN3", "COLUMN4",
                            "COLUMN5", "COLUMN6"
                          };
        int rl=row.length;
        int cl=column.length;

        ScrollView sv = new ScrollView(this);
        TableLayout tableLayout = createTableLayout(row, column,rl, cl);
        HorizontalScrollView hsv = new HorizontalScrollView(this);

        hsv.addView(tableLayout);
        sv.addView(hsv);
        setContentView(sv);

    }

    private TableLayout createTableLayout(String [] rv, String [] cv,int rowCount, int columnCount)
    {
        // 1) Create a tableLayout and its params
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setBackgroundColor(Color.BLACK);

        // 2) create tableRow params
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        for (int i = 0; i < rowCount; i++)
        {
            // 3) create tableRow
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundColor(Color.BLACK);

            for (int j= 0; j < columnCount; j++)
            {
                // 4) create textView
                TextView textView = new TextView(this);
                //  textView.setText(String.valueOf(j));
                textView.setBackgroundColor(Color.WHITE);
                textView.setGravity(Gravity.CENTER);

                String s1 = Integer.toString(i);
                String s2 = Integer.toString(j);
                String s3 = s1 + s2;
                int id = Integer.parseInt(s3);
                Log.d("TAG", "-___>"+id);
                if (i ==0 && j==0)
                {
                    textView.setText("0==0");
                }
                else if(i==0)
                {
                    Log.d("TAAG", "set Column Headers");
                    textView.setText(cv[j-1]);
                }
                else if( j==0)
                {
                    Log.d("TAAG", "Set Row Headers");
                    textView.setText(rv[i-1]);
                }
                else
                {
                    textView.setText(""+id);
                    // check id=23
                    if(id==23)
                    {
                        textView.setText("ID=23");

                    }
                }

                // 5) add textView to tableRow
                tableRow.addView(textView, tableRowParams);
            }

            // 6) add tableRow to tableLayout
            tableLayout.addView(tableRow, tableLayoutParams);
        }

        return tableLayout;
    }
}