edttext_ertefa=(EditText)findViewById(R.id.edttext_ertefa);
    edttext_ghaede=(EditText)findViewById(R.id.edttext_ghaede);

    btnmosalas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int input1=Integer.parseInt(edttext_ghaede.getText().toString().trim());
            int input2=Integer.parseInt(edttext_ertefa..getText().toString().trim());
            double masahat= input1 * input2/2;
        }
    });