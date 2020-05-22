View v = inflater.inflate(R.layout.fragment_trending, container, false);
button = findViewById(R.id...):
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSelection(view);

            }
        });

return v;