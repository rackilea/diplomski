public void jsonToProducts(String json){
    ArrayList<Product> products = null;
    if(json != null && json.length() > 0){
        try{
            Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
            products = new Gson().fromJson(json, listType);
        }
        catch(JsonParseException ex){
            ex.printStackTrace();
        }
    }
    // TODO: Replace when Gson supports Setters or Parameterized Constructors
    if(products != null && products.size() > 0){
        for(Product p : products){
            p.setProductId(p.getProductId());
            p.setName(p.getName());
        }
    }

    setProducts(products);
}