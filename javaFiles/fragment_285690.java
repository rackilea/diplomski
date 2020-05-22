Bundle b = getIntent().getExtras();
        age.setText(b.getCharSequence("age"));
        int checked = b.getInt("checked");


         if (checked==1){ // male
                    jk.setText("male");
                    int theage = Integer.parseInt(age.getText().toString());
                    int HRmax = 220 - theage;
                    hrmax.setText(String.valueOf(HRmax));
                } else {// female
                    jk.setText("female");
                    int theage = Integer.parseInt(age.getText().toString());
                    int HRmax = 226 - theage;
                    hrmax.setText(String.valueOf(HRmax));
                }