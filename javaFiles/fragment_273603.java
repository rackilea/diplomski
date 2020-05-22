return redundantProperty.entrySet()
                       .stream()
                       .flatMap(secondProperty ->
                           notEnoughProperty.entrySet()
                                            .stream()
                                            .filter(firstPropertyName -> secondProperty.getKey().contains(firstPropertyName.getKey()))
                                            .map(firstProperty -> {
                                                List<Attr> redundantPropAttrs = ...
                                                ...
                                                return new SimpleEntry<String,List<Attr>>(firstProperty.getKey(),redundantPropertyAttrs);
                                            }))
                       .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));