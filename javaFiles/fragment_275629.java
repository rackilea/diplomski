public <T> List<Student> getStudentsForKeyAttribute(
            Function<StudentKey, T> attrExtractor, T keyAttribute) {
            return schoolsMap.entrySet().stream()
                .filter(e -> attrExtractor.apply(e.getKey())
                        .equals(keyAttribute))
                .map(Entry::getValue)
                .collect(Collectors.toList());
        }