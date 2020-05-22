saldoButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
             Intent i= new Intent(currentActivity.this,thirdActivity.class);
             startActivity(i);

        }
    });