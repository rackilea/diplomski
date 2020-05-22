finalSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cardNumber= getContext().getSharedPreferences("pref",0)
                        .getInt("int",0);


            }
        });