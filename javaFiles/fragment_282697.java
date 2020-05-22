FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference notesRef = rootRef.collection("notes");
notesRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                float lat = Float.parseFloat(document.getString("Latitude"));
                float lng = Float.parseFloat(document.getString("Longitude"));
                String name = document.getString("Attraction Name");
                LatLng latLng = new LatLng(lat, lng);
                mMaps.addMarker(new MarkerOptions().position(latLng).title(name));
            }
        }
    }
});