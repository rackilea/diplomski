LinearLayout ll;
    ArrayList<Button> buttons = new ArrayList<Button>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create main layout which will host two linear layouts vertically
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        //create another two linear layouts which will host 5 buttons horizontally
        Linear linearLayout1 = new LinearLayout(this);
        Linear linearLayout2 = new LinearLayout(this);

        for (int i = 0; i < 10; i++) {
            buttons.add(createButton(i));
        }
        Collections.shuffle(buttons);

        //add first 5 buttons to first layout
        for (int i=0;i<5;i++) {
            linearLayout1.addView(buttons.get(i));
        }
        //add remaining 5 to second layout
        for (int i=5;i<10;i++){
            linearLayout2.addView(buttons.get(i));
        }
    //add two layouts to main layout
      ll.addView(linearLayout1);
      ll.addView(linearLayout2);


    //set main linear layout to be main layout of the actvitiy.
        setContentView(ll);

    }

    private Button createButton(final int i) {
        Button b = new Button(this);
        b.setText(i + "");
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Clicking button: " + i, Toast.LENGTH_SHORT).show();
            }

        });
        b.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        return b;
    }