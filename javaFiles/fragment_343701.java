public Purchase getPurchase(int itemNumber) {
    for(int i = 0; i < purchaseList.size(); i++) {
        if(purchaseList.get(i).getItemNo() == itemNumber) {
            return purchaseList.get(i);
        }
        else return 0;
    }
}