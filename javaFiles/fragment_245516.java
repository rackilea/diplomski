Button plus = findViewById(R.id.plus);
  plus.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
       // for orders numbers
       int number = Integer.parseInt(ordersTextView.getText().toString().trim());
       number = number+1;
       ordersTextView.setText(String.valueOf(number));
      // for total cost 
       Float cost =  Float.parseFloat(costTextView.getText().toString().trim())*number;
       costTextView.setText(String.valueOf(cost));
    }
});