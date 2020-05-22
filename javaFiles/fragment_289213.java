class FixedPricePromotion extends AbstractPromotion{
    String product;
    Double price;
    public void evaluate(Cart cart){
        for(String product : cart.getProducts()){
           if(product.equal(product)){
              //some code to discount y price
           }
        }
    }    
}