private RadioButton rb_1, rb_2;


 //in on createView
    rb_1 = (RadioButton) myView.findViewById(R.id.radioGram);
    rb_2 = (RadioButton) myView.findViewById(R.id.radioKilogram);

     rb_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
            rb1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        rb_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
            rb2.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });