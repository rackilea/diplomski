btn_baslat.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        String text = editxt_deger.getText().toString();
        if(text.equalsIgnoreCase("myalfa")){
            txt_yazi.setText("BAŞARDIN !");
        } else {
            txt_yazi.setText("BAŞARAMADIN !");
        }
    }
});