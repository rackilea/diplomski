Button feedbackbtn;
protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        feedbackbtn=(Button)findViewById(R.id.button_ID);
        feedbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 new PlainJavaClass().mailconfig("msg",ButtonActionFrontPage.class);
                }
        });
    }