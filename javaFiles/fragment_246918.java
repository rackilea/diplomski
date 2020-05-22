@Override
public void onDataChange(DataSnapshot dataSnapshot) {
   HashMap<String, Object> data = dataSnapshot.getValue();
   String newCon = data.get("newCon");
   textbox.setText(newCon);
}