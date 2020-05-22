buttonB.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
              buttonA.requestFocus();
                          buttonA.performClick();
                          //then your buttonB operation
            }
        });