private HashMap<String,String> getProperties(HttpServletRequest request) {
    return request.getParameterMap().entrySet().stream()
                 .filter(e -> e.getValue() != null && e.getValue().length > 0)
                 .map(e -> new SimpleEntry<>(e.getKey(), e.getValue()[0])) // This is part where you are sure that only one-to-one parameter value
                 .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v2, HashMap::new));
}