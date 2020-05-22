textView=findViewById(R.id.textview);
    textView.setOnClickListener(this);




int idSelec= grupoRadio.getCheckedRadioButtonId();
sexo= findViewById(idSelec);
String sex= sexo.getText().toString();
String correo= corr.getText().toString();
String pass=contra.getText().toString().trim();