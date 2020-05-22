DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child(userId).child("Tasks");

 ref.orderByChild("name").equalTo(nameofthetask).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
             for (DataSnapshot datas : dataSnapshot.getChildren()) { 
              String key=datas.getKey();
              String name=datas.child("name").getValue().toString();
              String priorities=datas.child("priority").getValue().toString();
              ref.child(key).child("done").setValue(isdone);
              ref.child(key).child("name").setValue(name);
              ref.child(key).child("priority").setValue(priorities);

                }
             } 
          }
            @Override
        public void onCancelled(FirebaseError firebaseError) {

           }

     });