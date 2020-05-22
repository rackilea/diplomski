public void delete_messages(Integer quantity) {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    db.collection("messages").orderBy("time", Query.Direction.DESCENDING).limit(quantity)
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        document.getReference().delete()
                            .addOnSuccessListener (aVoid -> Log.d("Kasowanie", "DocumentSnapshot successfully deleted!"))
                            .addOnFailureListener (e ->  Log.w("Kasowanie", "Error deleting document", e));
                    }
                } else {
                    Log.e("ERROR", "Error getting documents: ", task.getException());
                }
            });
}