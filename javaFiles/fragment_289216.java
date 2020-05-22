class FixedPricePromotionEvaluation implements PromotionEvaluation{
    FixedPricePromotion promotion;

    public FixedPricePromotionEvaluation(FixedPricePromotion promotion){
      this.promotion = promotion;
    }

    public boolean isMatch(String product){
       return product.equal(promotion.product)
    }

    public void applyPromotion(String product){
      // do your logic
    }


}