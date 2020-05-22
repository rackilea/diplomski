public Optional<Product> getMostExpensiveProduct(HashMap<Integer, Product> items) {
            Optional<Product> maxPriceProduct = 
               items.values()
                    .stream()
                    .reduce((Product a, Product b) ->
                            a.getPrice() < b.getPrice() ? b : a);

            return maxPriceProduct;
 }