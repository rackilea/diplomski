ArrayList<OrderDetailElement> orderDetails = yourMap.get("OrderDetails");
    List<String> products = new ArrayList<String>();
    if (orderDetails.size() > 0) {
        for (OrderDetailElement orderDetailElement : orderDetails) {
            products.add(orderDetailElement.getProduct_name());
        }
    }