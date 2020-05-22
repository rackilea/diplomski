Map map = new HashMap();
map.put("product_id", 1);
map.put("quantity", 1);
Object[] productdetails1=new Object [] {map};
Object param1[]=new Object[]{Utils.shoppingCartId,productdetails1};
Object param[]=new Object[]{Utils.sessionId,"cart_product.add",param1};
try {
    Object addtocart=client.callEx("call", param);
    Log.i("Out Put of Adding", addtocart.toString());
} catch (XMLRPCException e) {
    e.printStackTrace();
}