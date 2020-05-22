private InputStream inputStream;

//getter here
public InputStream getInputStream () {
  return inputStream;
}


public String execute(){
  productList= service.getProductList();//this method is getting list of products

  Gson gson = new Gson();
  JsonElement element = gson.toJsonTree(productList,
        new TypeToken<List<Product>>() {
        }.getType());
  JsonArray jsonArray = element.getAsJsonArray();
  inputStream = new ByteArrayInputStream(jsonArray.toString().getBytes());
  return "success";
}