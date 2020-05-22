FirebaseDatabase.getInstance().getReference().child("Your table name").orderByChild("email").equalTo(your searchable emailid ).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Iterator<DataSnapshot> dataSnapshots = dataSnapshot.getChildren().iterator();
        List<User> users = new ArrayList<>();
        while (dataSnapshots.hasNext()) {
            DataSnapshot dataSnapshotChild = dataSnapshots.next();
            User user = dataSnapshotChild.getValue(User.class);
            users.add(user);
        }
        String userids = "";
        List<User> temp = new ArrayList();
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getEmailid().equals("your searchable email")) {
                    temp.add(users.get(i));     
                    //Here you can find your searchable user
                    Log.e("temp", "+" + temp.get(i).getFirebaseId());
                    email = temp.get(i).getEmailId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Logs", e.toString());
        }
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});