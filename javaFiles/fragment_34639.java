stores.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<GeoPoint> list = new ArrayList<>();
            for (QueryDocumentSnapshot document : task.getResult()) {
                list.add(document.getGeoPoint("position"));
            }

            //Do what you need to do with your list
        }
    }
});