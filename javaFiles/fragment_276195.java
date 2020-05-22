public void addListenerOnButton() {
    spinner1=(Spinner) findViewById(R.id.spinner1);
    spinner2=(Spinner) findViewById(R.id.spinner2);
    button=(Button) findViewById(R.id.button);


    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

       str_grad=spinner1.getSelectedItem().toString();    // move these lines here
       str_predmet=spinner2.getSelectedItem().toString();

        Intent i=new Intent (v.getContext(), MainActivity.class);
        url = "http://192.168.1.102/test/spinner.php";
        url=url+"?grad="+str_grad+"&predmet="+str_predmet;
        i.putExtra("URL",url);

        startActivity(i);

        }
    });