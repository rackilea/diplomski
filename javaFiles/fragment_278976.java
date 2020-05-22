DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference countriesRef = rootRef.child("countries");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> urlList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String url = ds.child("Image").getValue(String.class);
            urlList.add(url);
        }

        int urlCount = urlList.size();
        int randomNumber = new Random().nextInt(urlCount);
        List<String> randomUrlList = new ArrayList<>();
        for (int i=1; i<=5; i++) {
            randomUrlList.add(urlList.get(randomNumber));
            //Set image to ImageView
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
countriesRef .addListenerForSingleValueEvent(valueEventListener);