/*Loading the Parent Layout*/
 LinearLayout ParentLayout = (LinearLayout)findViewById(R.id.ParentLayout);

    /*Dynamically creating your linear layouts*/
    for(int i=0; i<NumberOfLayouts; i++){
      LinearLayout linearLayout = new LinearLayout(getApplication());

        TextView textView = new TextView(this);
        textView.setText("Sample Text");

        linearLayout.addView(textView);

        ParentLayout.addView(linearLayout);

        /*Adding listener for the individual layouts*/
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //Your code or method to be executed while clicking the dynamically created linear layout
            }
        });
    }