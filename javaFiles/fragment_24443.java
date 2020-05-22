buttonWRGL.setOnClickListener(new Button.OnClickListener() {
    public void onClick(View v) {
        Intent intent = new Intent(this, NewActivity1.class);
        startActivity(intent);
    }
});