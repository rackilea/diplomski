button = (Button)findViewById(R.id.btnAddItem);
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Item added", Toast.LENGTH_LONG).show();
            }
        });