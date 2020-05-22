ObjectMapper mapper = new ObjectMapper(); // Jackson JSON lib entry-point

List<Map<String, String>> resultArray = resultList.stream()
    .map(json -> {
        try {
            return mapper.readValue(json, new TypeReference<Map<Striong, String>>() {});
        } catch (IOException e) {
            throw new UncheckedIOExpcetion(e);
        }
    })
    .filter(ev -> ev.entrySet().containsAll(filter.entrySet()))
    .collect(Collectors.toCollection(ArrayList::new));