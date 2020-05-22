Button btn_marine = (Button) findViewById(R.id.btn_unit_marine);
btn_marine.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(MainActivity.this, UnitActivity.class);
        intent.putExtra("unitType","marine")
        startActivity(intent);
    }
});