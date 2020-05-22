View.OnClickListener listener = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        if (((String) signImage.getTag()).equals(((Button) v).getText())) {
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            NextPicture();
        } else {
            Toast.makeText(MainActivity.this, "Wrongo!", Toast.LENGTH_SHORT).show();
        }
    }
};
button1.setOnClickListener(listener);
button2.setOnClickListener(listener);
...