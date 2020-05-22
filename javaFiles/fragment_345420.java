List<myDTO> result = responsesList.stream()
                .filter(d ->
                        d.getData().getTags().stream()
                            .anyMatch(t -> t.getKey().equals(key1) && t.getValue().equals(value1)))
                .filter(d ->
                        d.getData().getTags().stream()
                            .anyMatch(t -> t.getKey().equals(key2) && t.getValue().equals(value2)))
                .collect(Collectors.toList());