@Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.add_btn:
                String ItemEntered = ItemET.getText().toString();
                if(ItemEntered.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter some detail", Toast.LENGTH_LONG).show();
                } else {
                      adapter.add(ItemEntered);
                      ItemET.setText("");
                      FileHelper.writeData(items, this);
                      Toast.makeText(this, "item Added", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }