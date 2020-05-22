rootRef.collection("products").document("06cRbnkO1yqyzOyKP570").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                ArrayList<String> list = (ArrayList<String>) document.get("ip_range");
                Log.d(TAG, list.toString());
            }
        }
    }
});