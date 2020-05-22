public void onDataChange(DataSnapshot imagesSnapshot) {
    for (DataSnapshot imageSnapshot: imagesSnapshot.getChildren()) {
        imagesDir.add(imageSnapshot.child("address").getValue(String.class));
    }
    Log.i("MyTag", imagesDir.toString());
}