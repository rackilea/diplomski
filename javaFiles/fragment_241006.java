boolean acceptable;
try {
    item.setBarCode(barCode);
    acceptable = true;
}
catch(IllegalArgumentException e) {
    acceptable = false;
}

if(acceptable) {
        if(store.addItem(barCode)){
            System.out.println(store.stockedItems.get(barCode).getProductName() + " has been added to the store's inventory");
        }
        else {
            item.setQuantity(1);
            System.out.print("Enter the item's name: ");
            productName = scan.nextLine();
            productName = productName.toLowerCase();
            item.setProductName(productName);
            store.stockedItems.put(barCode, item);

            System.out.println(store.stockedItems.get(barCode).getProductName() + " has been added to the store's inventory");
        }
}

break;