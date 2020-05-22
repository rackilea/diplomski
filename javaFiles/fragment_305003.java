public void testMy() {
        db = FirebaseFirestore.getInstance();
        List<String> followingList = new ArrayList<>();
        followingList.add("tag1"); followingList.add("tag2"); followingList.add("tag3"); // ...
        List<Task> taskList = new ArrayList<>();

        for (String s : followingList) {
            Query query = db.collection("invites")
                    .whereEqualTo("uid", s)
                    .orderBy("imageUrl_1", Query.Direction.ASCENDING);; //followingList is a list of Strings that I want to query
            Task<QuerySnapshot> task = query.get();
            taskList.add(task);
        }

        Tasks.whenAllSuccess(taskList.toArray(new Task[taskList.size()])).addOnSuccessListener(new OnSuccessListener<List<Object>>() {
            @Override
            public void onSuccess(List<Object> objects) {
                @SuppressWarnings("unchecked")
                List<QuerySnapshot> querySnapshots = (List<QuerySnapshot>)(List<?>) objects;
                for (QuerySnapshot qs : querySnapshots) {
                    for (QueryDocumentSnapshot qds : qs) {
                        Log.d(TAG, qds.getData().toString());
                    }
                }
            }
        });
    }