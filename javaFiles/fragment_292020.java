FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference attractionsRef = rootRef.collection("attractions");

attractionsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<Attraction> attractionsList = new ArrayList<>();
            for (QueryDocumentSnapshot document : task.getResult()) {
                Attraction attraction = document.toObject(Attraction.class);
                attractionsList.add(attraction);
            }
            methodToProcessTheList(attractionsList);
        }
    }
});