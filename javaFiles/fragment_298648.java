public static ShopCart findCart(String sessionId){
   ShopCart sc = Cache.get(session.getId(),ShopCart.class);
   if(sc == null){
      sc = ShopCart.findCurrentUserCart(); //implement to find the cart of the current user
      Cache.set(sessionId,sc);
   }
   return sc; 
}