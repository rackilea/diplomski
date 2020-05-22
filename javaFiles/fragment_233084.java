step1btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent openStep = new Intent(MyActivity.this, Step1.class);
        startActivity(openStep);
    }
});