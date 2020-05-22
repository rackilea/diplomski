for (Map.Entry<String, Map<String, Object>> account : accounts.entrySet()) {
    Map<String, Object> accountVal = account.getValue();
    String id = accountVal.getOrDefault("ID", "").toString();
    Set<String> setValues = entitlementMap.getOrDefault(id, Collections.emptySet());
    accountVal.put("name", new HashSet<>(setValues));
}