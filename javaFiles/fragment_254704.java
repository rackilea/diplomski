public enum Group {

    INDUSTRY  ("Industry",   1, 4, 52, 77, 300),
    HEALTHCARE("Healthcare", 2, 3, 600, 601, 715);
    // ...

    int[] codes;
    String name;

    Group(String name, int... codes) {
        this.codes = codes;
        this.name = name;
    }

    // this map will hold mappings from code to `Group`
    // for use in `ofCode()` method
    static Map<Integer, Group> groups = new HashMap<Integer, Group>() {{
        for (Group g : Group.values()) {
            for (Integer c : g.codes)
                put(c, g);
        }
    }};

    public String getName() { 
        return name; 
    }

    static public Group ofCode(int code) { 
        return groups.get(code);
    }
}