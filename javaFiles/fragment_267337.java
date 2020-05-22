Button button = findViewById(R.id.button);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(A.this, "Hello!", Toast.LENGTH_SHORT).show();
    }
});

// Or in shorter way:
button.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Hello!", Toast.LENGTH_SHORT).show());