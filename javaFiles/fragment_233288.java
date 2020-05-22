Map<String, Map<String, String>> a = (Map<String, Map<String, String>>) yaml.load(input);

for (Map.Entry<String, Map<String, String>> t : a.entrySet()) {
    String outerKey = t.getKey();
    String innerValue = t.getValue().get(innerKey);
    System.out.println("OuterKey: " + outerKey + " InnerKey: " + innerKey + " VALUE:" + innerValue);
}