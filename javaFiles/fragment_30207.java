LinearLayout item = findViewById(R.id.linear_layout_duel_basic_easy);
    for (int i = 0 ; i < 10; i++) {
        View child = getLayoutInflater().inflate(R.layout.linear_layout_duel_1, null);
        item.addView(child);
        final int finalI = i;
        child.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked = " + finalI, Toast.LENGTH_LONG).show();
            }
        });
    }