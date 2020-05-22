final DatabaseReference root = FirebaseDatabase.getInstance().getReference();
    Query locationQuery = root.child("location").orderByChild("place").equalTo("london");
    locationQuery.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            // I am assuming you have your own custom location class that you push to firebase 
            Location location = dataSnapshot.getValue(Location.class);

            // make the second query inside the on Child Added method

            Query userQuery = root.child("users").orderByChild("location").equalTo(location);

            userQuery.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    // again I am assuming you have your own custom user class
                    User user = dataSnapshot.getValue(User.class);

                }

        }


}