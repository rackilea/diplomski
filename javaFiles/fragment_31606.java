mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Medicines");
final HashMap<String, Vector> Med = new HashMap<>();

mUserDatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
            for (DataSnapshot childDataSnapshot2 : childDataSnapshot.getChildren()) {
                // "MEDICINE NAME" childDataSnapshot2.getKey()

                Vector vector;

                if(Med.containsKey(childDataSnapshot2.getKey())) {
                    vector = Med.get(childDataSnapshot2.getKey());
                } else {
                    vector = new Vector();
                    Med.put(childDataSnapshot2.getKey(), vector);
                }

                vector.add(childDataSnapshot2.getValue(String.class));
            }
        }

        //Here Med contains all the data 
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});