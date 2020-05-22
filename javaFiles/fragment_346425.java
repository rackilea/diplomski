public void add (String product, int price) {

        if(shoppingCart.containsKey(product)) {
            Purchase purchase = shoppingCart.get(product);
            purchase.increaseAmount();
            //You might have to put the purchase back into the cart I'm not sure
        }
        else {
             Purchase purchase = new Purchase (product, 1, price);
             shoppingCart.put(product, purchase);
        }