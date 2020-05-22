private void getDetailedItem(final String itemId)
{
items.child(itemId);
items. addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
    {

        for(DataSnapshot datas: dataSnapshot.getChildren())
        {         

            if(pos.equals(datas.getKey().toString()))
            {
                try {
                    item = dataSnapshot.getValue(Items.class);

                    cart_item_name = datas.child("title").getValue().toString();
                    cart_item_amount = datas.child("amount").getValue().toString();
                    image_view_cart = datas.child("image").getValue().toString();

                    Toast.makeText(CartActivity.this, "Data setting",
                            Toast.LENGTH_SHORT).show();
                    item.setTitle(cart_item_name);
                    item.setAmount(cart_item_amount);
                    item.setImage(image_view_cart);

                    Items uploadUser = new Items();
                    uploadUser.setTitle(cart_item_name);
                    uploadUser.setAmount(cart_item_amount);
                    uploadUser.setImage(image_view_cart);

                    if(mFirebaseAuth.getCurrentUser()!=null){
                       items.child("UserNode").child(mFirebaseAuth.getCurrentUser().getUid()).setValue(
                                        item, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                        if (databaseError == null) {
                                            addToCartItems.add(item);
                                    cartRecyclerAdapter.notifyDataSetChanged();

                                            Toast.makeText(CartActivity.this, "Data is saved successfully",
                                                    Toast.LENGTH_SHORT).show();                                                    
                                        }
                                    }
                                });

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        updateAdapterData();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
});
}