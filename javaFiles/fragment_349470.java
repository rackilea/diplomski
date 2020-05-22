Map<Integer,Method> cc = new HashMap<>();
        cc.put(1, User.class.getDeclaredMethod("getCustomer"));
        cc.put(2, User.class.getDeclaredMethod("getNotes"));
        cc.put(3, User.class.getDeclaredMethod("getCustomerLocation"));
        cc.put(4, User.class.getDeclaredMethod("getReferenceNumber"));

        for (Entry<Integer, Method> map : cc.entrySet()) {
            Integer index = map.getKey();
            Method getter = map.getValue();
            Object value = getter.invoke(user);
            doSomethingUsefulWith(index, value);
        }