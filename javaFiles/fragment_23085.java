FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser(); 
Query reference;

                       reference = FirebaseDatabase.getInstance().
                       getReference("customers").orderByChild("customerId").equalTo(user.getUid());


                       reference.addListenerForSingleValueEvent(new 
                       ValueEventListener() {
                       @Override
                       public void onDataChange(DataSnapshot dataSnapshot) {
                       for(DataSnapshot datas: dataSnapshot.getChildren()){
                       String 
                         customerId =datas.child("customerId").getValue().toString();

                       String 
                         customerName =datas.child("customerName").getValue().toString();

                       String 
                         phone =datas.child("phone").getValue().toString();


                      }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                  });

    }