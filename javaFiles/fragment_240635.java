public void onTextChanged(CharSequence s, int start, int before, int count) {
   double billAmount = 0.0;
   if(s.length() != 0){
        billAmount = Double.parseDouble(s.toString());
   }
        tip10EditText.setText("" + billAmount * .1);
        tip15EditText.setText("" + billAmount * .15);
        tip20EditText.setText("" + billAmount * .2);
        total10EditText.setText("" + (billAmount + billAmount * 0.1));
        total15EditText.setText("" + (billAmount + billAmount * 0.15));
        total20EditText.setText("" + (billAmount + billAmount * 0.2));
}