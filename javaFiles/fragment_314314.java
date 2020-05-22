ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        if (!snapshot.hasChildren()) {
            System.out.println("List is empty");
        }
    }
    @Override
    public void onCancelled(FirebaseError error) {
    }
}