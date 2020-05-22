public void setRadios(int number) {

    for (int row = 0; row < 1; row++) { //add to first row
        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 1; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId((row * 2) + i);
            rdbtn.setText("Radio " + rdbtn.getId());
            rg.addView(rdbtn);
        }
        ((ViewGroup) findViewById(R.id.radiogroup)).addView(rg);
    }

  }