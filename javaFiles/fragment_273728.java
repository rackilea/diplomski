List<Customer> inputList = ...;
Map<City, List<Customer>> map = new HashMap<>();
for (Customer cust : inputList) {
    City city = cust.getCity();
    List<Customer> custList = map.get(city);
    if (custList == null) {
        custList = new ArrayList<>();
        map.put(city, custList);
    }
    custList.add(cust);
}