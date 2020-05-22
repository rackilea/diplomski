public void addProductToTotalSale(LineItem li) {
    addItemToSaleList();
    lineItem[lineItem.length-1] = li;
}

public void addItemToSaleList() {
   LineItem[] tempItemList = new LineItem[lineItem.length + 1];

   for (int i = 0; i < tempItemList.length; i++) {
     tempItemList[i] = lineItem[i];
   }
   lineItem = tempItemList;
}