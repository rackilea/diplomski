Query mQuery = ref.orderByChild("category").equalTo("Shop");
mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot,  String s) {
                Object ob = dataSnapshot.getValue();
                System.out.println("There are " + dataSnapshot.getKey() + " blog posts==" + dataSnapshot.getValue());
            }
 });