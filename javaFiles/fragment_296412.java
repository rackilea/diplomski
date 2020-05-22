Map<String,MyProduct> uniqueProducts = new HashMap<>();
for(int i=0; i<proNames.size(); i++){

    if(!uniqueProducts.contains(proNames.get(i))){
        //You've stated a requirement that you avoid duplication
        //before you even create a duplicate MyProduct. This if
        //before the construction meets that requirement.
        uniqueProducts.put(proNames.get(i),
            new MyProduct(imgs.get(i),proNames.get(i),proQty.get(i),proPrice.get(i)));
    }
}

Set<MyProduct> products = new HashSet<MyProduct>(uniqueProducts.values());