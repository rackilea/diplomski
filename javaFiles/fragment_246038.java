@Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.students_masterlist);
        db=openOrCreateDatabase("ClassManager",MODE_WORLD_WRITEABLE, null);


        Cursor c=db.rawQuery("SELECT StudPic, StudentID, LastName FROM MasterStudents", null);
        int count= c.getCount();
        c.moveToFirst();
        TableLayout tableLayout = new TableLayout(getApplicationContext());
        tableLayout.setVerticalScrollBarEnabled(true);
        TableRow tableRow;
        TextView textView, textView1;
        ImageView StudImageView;

        RelativeLayout rl=(RelativeLayout)findViewById(R.id.layout);
        ScrollView sv = new ScrollView(this);
        sv.addView(tableLayout);
        rl.addView(sv);
        for (Integer j = 0; j < count; j++)
        {
            tableRow = new TableRow(getApplicationContext());
            StudImageView = new ImageView(getApplicationContext());
            StudImageView.setPadding(20, 20, 20, 20);
            StudImage=c.getBlob(c.getColumnIndex("StudPic"));
            Bitmap b1= BitmapFactory.decodeByteArray(StudImage, 0, StudImage.length);
            StudImageView.setImageBitmap(b1);
            tableRow.addView(StudImageView);

            textView1 = new TextView(getApplicationContext());
            textView1.setText(c.getString(c.getColumnIndex("StudentID")));
            textView1.setPadding(20, 20, 20, 20);
            textView1.setTextColor(getResources().getColor(R.color.blueactionbar));
            textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
            textView1.setTypeface(null, Typeface.BOLD);
            tableRow.addView(textView1);

            textView = new TextView(getApplicationContext());
            textView.setText(c.getString(c.getColumnIndex("LastName")));
            textView.setPadding(20, 20, 20, 20);
            textView.setTextColor(getResources().getColor(R.color.blueactionbar));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
            textView.setTypeface(null, Typeface.BOLD);
            tableRow.addView(textView);
            tableLayout.addView(tableRow);
            c.moveToNext() ;
        }
        db.close();
        rl.requestLayout();

    }