while (set.next()){
    orderno=set.getInt(1);
    orderDate=set.getString(2);
    shipDate=set.getString(3);
    custId=set.getString(4);
    list.addOrder(list.new Order(orderno,custId,ccn));
}