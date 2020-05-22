Document orderRegelDocument = OrderRegelsVoorCopsView.getFirstDocument();
while (orderRegelDocument != null) {
    tempOrderRegel = OrderRegelsVoorCopsView.getNextDocument(orderRegelDocument);

    //do something here

    System.out.println("Nieuwe Orderregel");
    orderRegelDocument.recycle();  // recycle the one we're done with
    orderRegelDocument = tempOrderRegel;    
}