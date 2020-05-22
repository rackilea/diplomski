int i = 1;
for(DataSnapshot data: dataSnapshot.getChildren()){
    int id = getResources().getIdentifier("textview" + i, "id", getPackageName());
    TextView textview = (TextView) findViewById(id);
    String message = data.getKey().toString();
    textview.setText(message);
    i++;
}