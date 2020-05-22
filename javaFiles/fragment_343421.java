JSONObject car = new JSONObject();
car.put("car", new JSONObject());

JSONArray brands = new JSONArray();
brands.put("C");
brands.put("D");
car.put("brands", brands);

JSONArray cars = new JSONArray();
cars.put(car);

JSONObject json = new JSONObject();
json.put("cars", cars);

System.out.println(json.toString(2));