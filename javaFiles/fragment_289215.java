public interface PromotionEvaluation{

       boolean isMatch(String product);
       void applyPromotion(String product);
       default void evaluate(Cart cart){
            for(String product : cart.getProducts()){
               if(isMatch(product)){
                  applyPromotion(product);
               }
            }
        }       
}