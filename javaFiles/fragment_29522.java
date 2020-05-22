mUsers = new ArrayList<>();
    db.collection("users")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            Users users = document.toObject(Users.class);
                            mUsers.add(users);
                        }
//HERE
                        mAdapter = new UsersAdapter(MainActivity.this, mUsers);
                        mRecyclerView.setAdapter(mAdapter);
                        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar9);
                        progressBar.setVisibility(View.INVISIBLE);
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                }
            });
}