@Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Orange.class);
        startActivity(intent);
        finish();
    }