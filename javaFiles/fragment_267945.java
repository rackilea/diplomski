Map<String, Parcelle> output = mapLignesParcelles.entrySet().stream()
        .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()
                .stream()
                .filter(lp -> lp.getNature() != null && lp.getAutre_nature() != null)
                .findAny()
                .orElse(e.getValue().get(new Random().nextInt(e.getValue().size())))))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));