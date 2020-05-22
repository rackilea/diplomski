JSONObject arrayOfProducts = jsonObj.optJSONObject("Products");
    JSONArray products = arrayOfProducts.getJSONArray("Product");
    for (int i = 0; i < products.length(); i++) {
        JSONObject objects = products.getJSONObject(i);
        Iterator key = objects.keys();
        while (key.hasNext()) {
            String k = key.next().toString();
            if(k.equals("Name")) {
                if(objects.getString(k).equals("Camera")) {
            System.out.println("\nKey : " + k + "\nName : " + objects.getString(k) + ", \nValue : " + objects.getInt("Value"));
                }
            }
        }
    }