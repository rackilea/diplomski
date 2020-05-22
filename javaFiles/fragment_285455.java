return list.stream().map(e -> {
    try {
        return fieldType.cast(f.get(e));
    } catch (Exception e) {
        return /* something else */ null; // or throw an unchecked exception
    }
}).collect(Collectors.toList());