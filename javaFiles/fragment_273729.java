Map<City, List<Customer>> map = new HashMap<>();
for (Customer cust : inputList) {
    City city = cust.getCity();
    map.computeIfAbsent(city, k -> new ArrayList<>());
    map.get(city).add(cust);
}