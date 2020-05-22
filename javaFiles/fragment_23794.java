FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
String userId=user.getUid();
DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user_study_condition");

reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
   String name=datas.child("name").getValue().toString();
     }
 }
@Override
public void onCancelled(DatabaseError databaseError) {
    }
 });