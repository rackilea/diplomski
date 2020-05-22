CollectionReference restaurantQuery = firebaseFirestore.collection("Restaurant_Data").document(restaurantId).collection("Menu_Card");
restaurantQuery.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
    @Override
    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
        for (QueryDocumentSnapshot menuDocument : queryDocumentSnapshots) {
            if (menuDocument.getString("menuItemName").equals(menuItemName)) {
                orderItemImage = menuDocument.getString("menuItemImage");
                Log.d(TAG, "item image 1:"+ orderItemImage);

                MealplanMenu mealplanMenu = new MealplanMenu(menuItemName, orderDocument.getString("menuItemQuantity"),orderItemImage);
                mealplanMenuArrayList.add(mealplanMenu);
            }
        }
        mealplanMenuAdapter = new MealplanMenuAdapter(adapterContext, mealplanMenuArrayList);    
        mpDetailsViewHolder.mealplanMenuRecycler.setAdapter(mealplanMenuAdapter);
    }
});