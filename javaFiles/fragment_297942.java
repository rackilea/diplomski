mfirebaseFirestore.collection("Friendship").document(mCurrentUser).collection("FriendshipStatus")
                .whereEqualTo("RequestStatus", "Completed")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("abc", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("abc", "Error getting documents: ", task.getException());
                        }
                    }
                });