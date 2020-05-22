bt1.setOnClickListener(new View.OnClickListener() { 
    @Override
    public void onClick(View v) {

        String strScore = etxt1.getText().toString();

        int score = Integer.parseInt(strScore);

        if (score >= 91) {
            etxt2.setText("A");
        }
        else if (score >= 81) {
            etxt2.setText("B");
        }
        else if (score >= 81) {
            etxt2.setText("B");
        }
        else if (score >= 71) {
            etxt2.setText("C");
        }
        else if (score >= 61) {
            etxt2.setText("D");
        }
        else {
            etxt2.setText("F");
        }
    }
});