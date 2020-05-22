Button button_a;
        button_a = view.findViewById(R.id.button1);
        button_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,
                        ScrollingActivity1.class);
                startActivity(myIntent);
            }
        });