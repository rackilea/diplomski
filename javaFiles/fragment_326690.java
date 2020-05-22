this.parameterMap = new ImmutableMap.Builder<>();
for (Map.Entry<String,String> entry : key.parameterMap.entrySet()) {
    if (!"is_clientid".equals(entry.getKey()) {
        this.parameterMap.put(entry.getKey(), entry.getValue());
    }
}