CollectionReference linksRef = rootRef.collection("Links");
linksRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                Map<String, Object> map = new HashMap<>();
                map.put("propertyName", "propertyValue");
                placesRef.document(document.getId()).update(map);
            }
        }
    }
});