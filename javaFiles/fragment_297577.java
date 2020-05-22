button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webstring = web.getText().toString();
                Toast.makeText(MainActivity.this, webstring + "asd", Toast.LENGTH_SHORT).show();
            }
        });