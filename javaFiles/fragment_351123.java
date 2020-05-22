bsave.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        data=et.getText().toString();
        Toast.makeText(MainActivity.this,data, Toast.LENGTH_SHORT).show();

    }
});