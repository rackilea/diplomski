final ImageButton buttonClearCounter = (ImageButton)findViewById(R.id.imageButton);
    button.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        clicked1 = 0;
        clicked2 = 0;
        text1.setText("  " + clicked1 + " SHOTS");
        text2.setText("  " + clicked2 + " CUPS");

    }