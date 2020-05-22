add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    TextView prezzo = (TextView) findByIdRecursively(v, R.id.editText2);
               String prezzoStr = prezzo.getText().toString();
            }
        });