Map<Person, List<Address>> restructure(List<Map<Person, Address>> data) {
    Map<Person, List<Address>> result = new HashMap<>();
    for (Map<Person, Address> map : data) {
        for (Map.Entry<Person, Address> entry : map.entrySet()) {
            List<Address> addresses = result.get(entry.getKey());
            if (addresses == null) {
                addresses = new LinkedList<>(); // or ArrayList, or ...
                result.put(p, addresses);
            }
            addresses.add(entry.getValue());
        }
    }
    return result;
}