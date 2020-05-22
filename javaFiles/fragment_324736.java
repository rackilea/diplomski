Set<Category> categories = Arrays.stream(sentence.split("\\s"))
        .map(s -> {
            for (Set<String> keywords : map.keySet()) {
                if (keywords.contains(s)) {
                    return Optional.of(map.get(keywords));
                }
            }
            return Optional.<Category>empty();
        })
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toSet());