HttpSession session = request.getSession(true);
shoppingcart shop = (shoppingcart)session.getValue("shop");
if(shop == null) {
    shop = new shoppingcart();
    session.putValue("shop", shop);
}

shop.ins(p);