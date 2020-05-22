firebaseFirestore = FirebaseFirestore.getInstance();
Query postOrder = firebaseFirestore.collection("user_post").orderBy("time_stamp",Query.Direction.DESCENDING);

//Snapshot listener help us to retrive the data in real time
postOrder.addSnapshotListener(new EventListener<QuerySnapshot>() {
    @Override
    public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
        //check for any changes in document
        for (DocumentChange doc: documentSnapshots.getDocumentChanges()){
            //check if document get added
            if (doc.getType() == DocumentChange.Type.ADDED){
                Wall_post wall_post = doc.getDocument().toObject(Wall_post.class);
                wallPosts_list.add(wall_post);

                wallpostRecyclerAdapter.notifyDataSetChanged();
            }
        }     
    }
});