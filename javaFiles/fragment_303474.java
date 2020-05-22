FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
rootRef.collection("aic").document("ceo").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Map<String, Object> map = document.getData();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getKey().equals("ip_range")) {
                        Log.d("TAG", entry.getValue().toString());
                    }
                }
            }
        }
    }
});