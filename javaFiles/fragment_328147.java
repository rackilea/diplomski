for(int i = 0; i < products.size(); i++) {
    json += "{" +
          "\"ID\": " + products.get(i).getId() + "," +
          "\"quantity\": " + products.get(i).getQuantity() + " }";
    if(i != products.size() - 1) json += ",";
}