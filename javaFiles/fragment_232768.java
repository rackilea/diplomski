FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference offersDataRef = rootRef.collection("MartWayDB").document("Offers")
    .collection("OffersData");
offersDataRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            String[] array = new String[task.getResult().size()];
            int count = 0;
            for (QueryDocumentSnapshot document : task.getResult()) {
                String itemName = document.getString("itemName");
                array[count] = itemName;
                Log.d(TAG, itemName);
                count++;
            }

            //Do what you need to do with your array
        }
    }
});