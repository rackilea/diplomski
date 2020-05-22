MyRef.orderByChild("email").equalTo("blabla@blabla.com").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot child: dataSnapshot.getChildren()) {
            Log.d("User key", child.getKey());
            Log.d("User ref", child.getRef().toString());
            Log.d("User val", child.getValue().toString());
        }
    }