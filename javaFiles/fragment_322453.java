static class State {
    String name;
    int i1, i2;
    State(String name, int i1, int i2) {
        this.name = name;
        this.i1 = i1;
        this.i2 = i2;
    }
}

final static Map<String, Map<String, State>> countryStateMap;

static {
    countryStateMap = new HashMap<>();
    Map<String, State> usa = new HashMap<>();
    usa.put("NY", new State("NY", 100, 100));
    usa.put("CO", new State("CO", 200, 200));

    Map<String, State> ca = new HashMap<>();
    ca.put("Quebec", new State("Quebec", 100, 100));

    // and so on

    countryStateMap.put("USA", usa);
    countryStateMap.put("CA", ca);
}