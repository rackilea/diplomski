btnupdate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name = nameText.getText().toString();
        String age = ageText.getText().toString();
        dbManager.update(_id, name, age);
        Toast.makeText(getApplicationContext(), "Updated successfully!", Toast.LENGTH_SHORT).show();
    }
});