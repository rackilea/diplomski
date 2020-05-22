DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users");
ref.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) { 
String name = dataSnapshot.child("name").getValue().toString(); 
name1.setText(name);
}