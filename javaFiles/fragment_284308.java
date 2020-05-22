chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(!chk.isChecked()) {
                   sp.setCheck(true);
                }
                else {
                    sp.setCheck(false);
                    chk.setChecked(false);
                }
            }
        });