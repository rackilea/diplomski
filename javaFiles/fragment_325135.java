ArrayList<String> names = new ArrayList<>();
myRef.child("Administrador").child("usuarios").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                String name = postSnapshot.child("nombre").getValue(String.class);
               names.add(name);

                }};
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }});