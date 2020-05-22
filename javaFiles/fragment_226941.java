public boolean addCartItem(ProductEntity product, int quantityPurchased){
    for (Orderitem current : cartItems) {
        if (current.getItemCode().equals(product.getItemCode())) {
            // adding duplicate entry.
            return false; // or handle adding differently
        }
    }

    // now that we're sure that the item doesn't already exist in the basket

    Orderitem basketItem=new Orderitem();
    basketItem.setItemcode(product.getItemcode());
    basketItem.setItemdescription(product.getItemdescription());
    basketItem.setUnitprice(product.getUnitprice());
    basketItem.setQuantitypurchased(quantityPurchased);
    basketItem.setSubtotal(quantityPurchased*basketItem.getUnitprice());
    cartItems.add(basketItem);
    return true;
}