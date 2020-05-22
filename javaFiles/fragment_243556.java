for (String state : keys) {
       // Get the value i.e. `Capital` object corresponding to the `key` i.e. `State`
        Capital cap = StateCap.get(state);
        System.out.println(cap.getName());
        System.out.println(cap.getPop());
        .
        .
        blah blah
    }