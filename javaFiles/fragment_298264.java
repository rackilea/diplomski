DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Posts").child(userKey);
ref.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
 for(DataSnapshot datas: dataSnapshot.getChildren()){
      String body=datas.child("body").getValue().toString();
      String title=datas.child("title").getValue().toString();
    }


}

@Override
public void onCancelled(DatabaseError error) {

    }
});