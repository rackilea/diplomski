Map<String, BiConsumer<Employee, String>> consumerMap = new HashMap<>();
    consumerMap.put("name", Employee::setFirstName);
    consumerMap.put("ads", Employee::setMyAddress);
    consumerMap.put("country", Employee::setDealCountry);
    //and so on

    Map<String, String> map = new HashMap<>();//the data from your database 
    Employee e = new Employee();
    if (map != null) {
        consumerMap.forEach((key, value) -> {
            if (map.containsKey(key)) {
                //value is the BiConsumer
                value.accept(e, map.get(key));
            }
        });
    }