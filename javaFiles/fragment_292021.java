public void readData(MyCallback myCallback) {
    attractionsRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if (task.isSuccessful()) {
                List<Attraction> attractionsList = new ArrayList<>();
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Attraction attraction = snapshot.toObject(Attraction.class);
                    attractionsList.add(attraction);
                }
                myCallback.onCallback(attractionsList);
            }
        }
    });
}