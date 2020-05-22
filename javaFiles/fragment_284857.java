public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        final DatePicker dp2 = new DatePicker(this);
        final Button btn2 = new Button(this);
        final Button magicButton = new Button(this);
        final TextView txt2 = new TextView(TestActivity.this);

        dp2.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn2.setText("set Date");

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                txt2.setText("You selected "
                    + dp2.getDayOfMonth() + "/" + (dp2.getMonth() + 1) 
                    + "/" + dp2.getYear());
            }
        });

        magicButton.setText("Magic Button");
        magicButton.setOnClickListener(new View.OnClickListener()    
            public void onClick(View arg0) {
                dp2.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
            }
        });

    ll.addView(dp2);
    ll.addView(btn2);
    ll.addView(magicButton);
    ll.addView(txt2);

    setContentView(ll);
}