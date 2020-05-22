// Add all polls in ref as rows
polls.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        for (DataSnapshot child : snapshot.getChildren()) {
            ...
        }
    }
}