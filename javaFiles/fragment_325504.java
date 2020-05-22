Gson gson = new Gson();
    Type mapType = new TypeToken<Map<String,List<Map<String, String>>>>() {}.getType();
    Map<String,List<Map<String, String>> >map = gson.fromJson(responseStr, mapType);
    System.out.println(map);

    Customers c = new Customers();

    c.setCustomers(map.get("Customers"));

    System.out.println(c.getCustomers());