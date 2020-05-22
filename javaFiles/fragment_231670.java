mRef.child("Monday").orderByKey().startAt("9").endAt("18").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot child : dataSnapshot.getChildren()) {
                HashMap<String, String> value = (HashMap<String, String>) child.getValue();
                String module = value.get("module");
                String room = value.get("room");
                System.out.println(room + module);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });