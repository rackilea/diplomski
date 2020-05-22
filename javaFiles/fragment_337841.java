@Override
        public void onClick(View view) {
            Double fruit_1_total = convert_and_multiply(R.id.v, R.id.s);//, fruit_2_total, fruit_3_total;

            Toast.makeText(c, Double.toString(fruit_1_total),Toast.LENGTH_LONG).show();
        }

        public double convert_and_multiply(int priceId, int amtId) {
           TextView price = findViewById(priceId);
           Spinner amount = findViewById(amtId);
           Double total = Double.valueOf(amount.getSelectedItem().toString()) * Double.parseDouble(price.getText().toString());

          return total;
        }