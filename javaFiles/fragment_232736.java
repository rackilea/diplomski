List<GenericKeyValueHolder<Integer>> r = 
    searchAttributes.rowMap()
                    .entrySet()
                    .stream()
                    .map(e -> new GenericKeyValueHolder<>(e.getKey(), e.getValue()))
                    .collect(Collectors.toList());