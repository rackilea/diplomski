_decrease.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            if(_counter <= 0) {
                 Log.d("src", "Decreasing value...");
                 _counter--;
                 _stringVal = Integer.toString(_counter);
                 _quantity.setText(_stringVal);

                 Toast.makeText(getApplicationContext(), "You cannot order a negative number or more than 10 coffees",
                 Toast.LENGTH_LONG).show();
            }
        }
    });