Map<Integer,Getter<User,?>> cc = new HashMap<>();
    cc.put(1, (u) -> u.getCustomer().getName());
    cc.put(2, (u) -> u.getNotes());
    cc.put(3, (u) -> u.getCustomerLocation());
    cc.put(4, (u) -> u.getReferenceNumber());
    for (Entry<Integer,Getter<User,?>> map : cc.entrySet()) {
        Integer index = map.getKey();
        Getter<User,?> getter = map.getValue();
        Object value = getter.get(user);
        doSomethingUsefulWith(index, value);
    }