private Button button1;
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    button1=(Button)findViewById(R.id.button);
    button1.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
             switch(v.getId()){
                case R.id.button:

                     LinearLayout ll=(LinearLayout)findViewById(R.id.linearLayout1);
                     System.out.println(ll.getWidth()+" "+ll.getHeight());
                     LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ll.getWidth(),ll.getHeight());
                     YourView yourView = new YourView(getBaseContext());
                     yourView.setBackgroundColor(Color.WHITE);
                     ll.addView(yourView,params);
                    break;
             }

        }

    });

}