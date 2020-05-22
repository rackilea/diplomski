button.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v) {
        String text="";
            if (textView.getText().equals("ON")) {
               text="OFF";

            }
            else if (textView.getText().equals("OFF")) {
                text="ON";

            }
        textView.setText(text);
    }

});