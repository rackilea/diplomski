ShoppingList cart = (ShoppingList)getSupportFragmentManager().findFragmentById(R.id.shoppinglistfrag);
if(cart != null){    
    cart.setCart(view,itemName,qty,beforeTax,afterTax);
}
else{
    Log.e(TAG, "null cart");
}