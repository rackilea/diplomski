public void removeProductPrice(ProductPrice price){
    Product p = price.getProduct();
    Map<Currency, ProductPrice> productPriceMap = p.getProductPriceMap();
    productPriceMap.remove(price);

    List<ProductPrice> prices = p.getProductPrices();
    prices.remove(price);
    p.setProductPrices(prices);

    p.removeProductPriceMap(price);

    productDao.merge(p);
}

public void saveProductPrice(ProductPrice price, boolean isNew){
    Product p = price.getProduct();
    List<ProductPrice> prices = p.getProductPrices();
    if(isNew ){
        prices.add(price);
    }
    else{
        int i = 0;
        for (ProductPrice tp: prices){
            if (tp.getId() == price.getId()){
                prices.set(i, price);
                break;
            }
            i++;
        }
    }

    p.setProductPrices(prices);
    productDao.merge(p);
}