mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("Seller");

mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot sellerSnapshot : dataSnapshot.getChildren()) {
            DataSnapshot impInfoSnapshot = sellerSnapshot.child("ImpInfo");
            ShopSellerInfo shopSellerInfo = impInfoSnapshot.getValue(ShopSellerInfo.class);
            mShopSellerInfo.add(shopSellerInfo);
            mNearBySellerAdapter = new NearBySellerAdapter(getContext(), mShopSellerInfo);
            mRecyclerView.setAdapter(mNearBySellerAdapter);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException();
    }
});