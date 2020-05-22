public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
LinearLayout ll = (LinearLayout) findViewById(R.id.add_layout);

            TableLayout layout = new TableLayout (this);
            layout.setLayoutParams( new TableLayout.LayoutParams(85,85) );

            layout.setPadding(8,8,8,8);

            for (int f=0; f<=6; f++) {

                TableRow tr = new TableRow(this);

               tr.setBackgroundColor(Color.BLACK);
               tr.setPadding(0,0, 0,2 );

               TableRow.LayoutParams llp = new        
                       TableRow.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
               llp.setMargins(0, 0, 2, 0);//2px right-margin

               //New Cell

               for (int c=0; c<=288; c++) {

                   LinearLayout cell = new LinearLayout(this);
                   cell.setBackgroundColor(Color.WHITE);
                   cell.setLayoutParams(llp);//2px border on the right for the cell

                    TextView b = new TextView (this);
                    b.setText("Sample");
                    b.setTextSize(10.0f);
                        b.setHeight(60);
                        b.setWidth(70);
                    b.setPadding(0, 0, 4, 0);

                    cell.addView(b);
                    tr.addView(cell);

               } // for
                layout.addView(tr);
            } // for
            ll.addView(layout);
//          super.setContentView(layout);
        } // ()