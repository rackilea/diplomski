public boolean addToCart(String name, double price, int quantity){
    Items n = new Items (name, price, quantity);

    for(int i = 0; i < numItems; i++){
        if(itemList[i].getName().equals(name)) {
            itemList[i].quantity += quantity;
            return true;
        }
    }

    if(numItems == INITIAL_CAP)
        return false;

    itemList[numItems] = n;
    numItems += 1;
    return true;
}