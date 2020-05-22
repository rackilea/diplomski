DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("masterSheet");
ref.addValueEventListener(new ValueEventListener(){
@Override
public void onDataChange(DataSnapshot dataSnapshot){
for(DataSnapshot data: dataSnapshot.getChildren()){
String email=data.child("3").getValue().toString();
DatabaseReference refs=FirebaseDatabase.getInstance().getReference().child("EmailList").push();
 refs.child("email").setValue(email);
      }
   }

@Override
public void onCancelled(FirebaseError firebaseError) {


 }
 });