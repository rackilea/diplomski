final EditText answerbox = (EditText) findViewById(R.id.answer_box);

    Button btn = (Button) findViewById(R.id.button1);
    btn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            String Answr = answerbox.getText().toString();

            Integer answer = Integer.valueOf(Answr);
            if (answer == (no2 + no1)) {
                num11.setText("OK OK OK ");
            } else {
                num11.setText("No No No");
            }
        }
    });