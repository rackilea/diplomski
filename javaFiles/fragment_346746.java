DatabaseReference users = ref.child("name");
users.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(DataSnapshot ds : snapshot.getChildren()) {
            String lastname = ds.getValue(String.class);
            arrayList.add(lastname);
        }
        if(arrayList.contains("Lovelace")) {
            System.out.println("first name exists");
        } else {
            System.out.println("does not exist");
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
});