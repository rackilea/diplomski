bBasket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText Wood = (EditText) findViewById(R.id.Wood);
                String str = Wood.getText().toString();
                if (str.length() == 0) {
                    Wood.requestFocus();
                    Wood.setError("FIELD CANNOT BE EMPTY");
                } else if (str.length() >= 2) {
                    Wood.requestFocus();
                    Wood.setError("You can only type one letter!");
                } else {
                   Intent intent2 = new Intent(Letters.this, Basket.class);
                    intent2.putExtra("MY_INFO",str + " - Letters" + price );
                    TextView price = (TextView) findViewById(R.id.price);
                    String pri = price.getText().toString();
                    intent2.putExtra("£",pri);
                    startActivity(intent2);
                }
            }
        });