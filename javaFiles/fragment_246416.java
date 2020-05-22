public void imageButtonListener(){
    ImageButton button1 =(ImageButton) getView().findViewById(R.id.SugarButton);
    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           openArticleWith("This is title for first button", "This is content for first buttton");
        }
    });
 }