OrderInfo oi = new OrderInfo();
oi.setCustomerId(1);
oi.setSpecialInstructions("Leave on porch");

ArrayOfProductInfo ap = new ArrayOfProductInfo(); // this is web service's class's list
List<ProductInfo> lp = ap.getProductInfo(); // here we obtain a generic list reference from the above

ProductInfo pinf = new ProductInfo();

pinf.productID = 2;
pinf.quantity = 14;
pinf.currPrice = new BigDecimal("3.95");

lp.add(pinf);

pinf = new VEProductInfo();
pinf.productID = 4;
pinf.quantity = 6;
pinf.currPrice = new BigDecimal("0");

lp.add(pinf); // second product

oi.setItems(ap); // this adds product list to the order object!

WebService s = new WebService();
WebServiceSoap soapport = s.getWebServiceSoap();
soapport.createOrder(oi); // voila, passing order to the web service method.