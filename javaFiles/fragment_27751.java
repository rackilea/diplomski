listOfPossibleParams.entrySet()
                    .stream()
                    .filter(p -> {
                        Object v = p.getValue();
                        return !(v instanceof String) || !StringUtils.isBlank((String) v);
                    })
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));