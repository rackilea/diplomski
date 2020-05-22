private Product findMatch( List<Product> products, Map<String, String> map )
{

    for (Product product : products) 
    {

        ArrayList<ProductFeature> productFeatures = product.getProductFeatures();

        boolean found = true;
        for ( ProductFeature feature : productFeatures )
        { 
           if ( map.containsKey( feature.name ) && map.get( feature.name ).equals( feature.value ) )
           {
              continue;
           }
           found = false;
           break;
        }

        if ( found ) 
        {
           return product;
        }
    }

    return null;

}