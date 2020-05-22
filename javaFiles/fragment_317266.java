send.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {

       String MSG= et.getText().toString();  //<< get value from EditText here
       msg_send.putExtra(Message_send, MSG);            
       startActivity(msg_send);
    }
});