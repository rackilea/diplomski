elements.stream()
    .map(first -> {
       Attribute newAttribute = elements.stream().filter(second -> !first.equals(second))
                .map(second -> computeChange(first, second))
                .reduce(first.getAttribute(), (a, b) -> a.add(b))
                return new Element(first.getEntry(), newAttribute, first.getValue());
            }).collect(Collectors.toList()));