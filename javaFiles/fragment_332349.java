MyCard customCard1 = new MyCard(cardTitle.getText().toString(),
            cardbuttonon.getText().toString(),
    cardbuttonon.getText().toString(),
    new View.OnClickListener() {
        public void onClick(View v) {
            String[] url={"url"};
            new onoff(MainActivity.this).execute(url);
        }});