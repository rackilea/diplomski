class PromotionService {
    void evaluation(Cart cart){
        for(AbstractPromotion p : getPromotions){                
               p.evaluate(cart);
        }
    }
}