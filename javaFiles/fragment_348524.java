public void buttonAbout1(View v) {
Button buttonAbout1 = (Button) findViewById(R.id.buttonAbout1);
assert buttonAbout1 != null;
    buttonAbout1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(GMOEd.this,About2.class));
        }
    });
}