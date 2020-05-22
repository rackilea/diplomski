Map<String,MyProduct> uniqueProducts = new HashMap<>();
for(TypeOfEnumerator enumerator : enumerators){

    if(!uniqueProducts.contains(getProName(enumerator))){
        //You've stated a requirement that you avoid duplication
        //before you even create a duplicate MyProduct. This if
        //before the construction meets that requirement.
        uniqueProducts.put(getProName(enumerator),
            new MyProduct(getImg(enumerator),getProName(enumerator),getQty(enumerator),getPrice(enumerator)));
    }
}