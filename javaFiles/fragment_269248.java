textView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), productName, Toast.LENGTH_SHORT).show();
    }
});