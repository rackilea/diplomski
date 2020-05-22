dialect "mvel"

rule "Applying taxes to imported products."
when

  // Take the order from working memory and get the product list from it
  $order: Order( $products: products != null )

  // Get only the imported products
  $product: Product( isImported == true ) from $products
then
  $product.setSale_tax($product.getPrize() * (5d/100));  
  $order.setTotalPrize($product.getSale_tax() + $product.getPrize());
  $order.setTotalTaxes($product.getSale_tax());
  System.out.println($order.toString());
  System.out.println($order.getTotalPrize()); 
  System.out.println($order.getTotalTaxes());
end