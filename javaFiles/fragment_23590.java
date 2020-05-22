myRef.addListenerForSingleValueEvent(new ValueEventListener() {
@Override 
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
      for(DataSnapshot datas: dataSnapshot.getChildren()){
         String keys=datas.getKey(); 
         String latitudes=datas.child("latitude").getValue().toString();
         String location=datas.child("location").getValue().toString();
         String longitude=datas.child("longitude").getValue().toString();
      } 
    }
 });