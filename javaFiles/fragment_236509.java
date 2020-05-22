retrieve.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showList(listName.getText().toString());
    }
});

public void showList(String listName){
    Cursor res = myDb.getList(listName);
    if(res.getCount() == 0){
    Toast.makeText(MainActivity.this,"Error finding list", Toast.LENGTH_LONG).show();
   //return;
    }
}

StringBuffer buffer = new StringBuffer();
    buffer.append(res.getString(2));
listDetails.setText(buffer); //Not working yet!!!!
}