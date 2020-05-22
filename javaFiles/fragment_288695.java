restaurantQuery.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
    @Override
    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
        for (QueryDocumentSnapshot menuDocument : queryDocumentSnapshots) {
            if (menuDocument.getString("menuItemName").equals(menuItemName)) {
                orderItemImage = menuDocument.getString("menuItemImage");
                Log.d(TAG, "item image 1:"+ orderItemImage);

                // Place your code here, or call methods that depend on orderItemImage
            }
        }
    }
});