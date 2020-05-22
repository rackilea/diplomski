Button confirm = (Button) findViewById(R.id.add);
    confirm.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            EditText playername = (EditText) findViewById(R.id.userinput);
            if(playerList.size() < 10) {
               playerList.add(playername.getText().toString());
               adapter.notifyDataSetChanged();
               playername.setText("");
            } else {
                // do nothing
            }
        }
     });