String jsonString; // initialized as you can
GsonBuilder gsonBuilder = new GsonBuilder();
gsonBuilder.setDateFormat("MM-dd-yyyy HH:mm"); // setting custom date format
Gson gson = gsonBuilder.create();
Product product = gson.fromJson(jsonString, Product.class);
// Do whatever you want with the object it has its fields loaded from the json