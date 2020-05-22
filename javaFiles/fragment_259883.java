private HashMap<String, Integer> areaCodes = new HashMap<String, Integer>();

public void addAreaCode(String areaCode) {
    if (areaCodes.containsKey(areaCode)) {
        areaCodes.put(areaCode, areaCodes.get(areaCode) + 1);
    } else {
        areaCodes.put(areaCode, 1);
    }
}

public void foo() {
    addAreaCode("351");
    addAreaCode("351");
    addAreaCode("111");

    for (String areaCode : areaCodes.keySet()) {
        System.out.printf("%s:%d\n", areaCode, areaCodes.get(areaCode));
    }
}