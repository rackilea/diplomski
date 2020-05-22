public double getPriceForName(String itemName){

    return StockData.getStock()
            .values()
            .stream()
            .filter(item->item.getName().equals(itemName))//filter only those whit the given name
            .mapToDouble(StockData.Item::getPrice)//get item price
            .findFirst()//Item name should be unique then it is ok to do this
            .getAsDouble();//if there is no item with the given name this will throw a NoSuchElementException
}

public int getQuantityForName(String itemName){

    return StockData.getStock()
            .values()
            .stream()
            .filter(item->item.getName().equals(itemName))//filter only those whit the given name
            .mapToInt(StockData.Item::getQuantity)//get item quantity
            .findFirst()//Item name should be unique then it is ok to do this
            .getAsInt();//if there is no item with the given name this will throw a NoSuchElementException
}