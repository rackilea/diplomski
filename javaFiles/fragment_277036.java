DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

reference.orderByChild("nomeProf").equalTo("glagla").addListenerForSingleValueEvent(new ValueEventListener() {
 @Override
public void onDataChange(DataSnapshot dataSnapshot) {
for(DataSnapshot datas: dataSnapshot.getChildren()){
        String teste = datas.getKey();
    }
 }
   @Override
public void onCancelled(@NonNull DatabaseError databaseError) { 
     throw databaseError.toException(); 
    }
 });