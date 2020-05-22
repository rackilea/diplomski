List<Class<?>> classes = Stream.of("java.lang.Object", "java.lang.Integer", "java.lang.String")
            .map(className -> {
                try {
                    return Optional.of(Class.forName(className));
                } catch (Exception e) {
                    return Optional.<Class<?>>empty();
                }
            })
            .filter(Optional::isPresent) // ignore empty values
            .map (Optional::get) // unwrap Optional contents
            .collect(Collectors.toList());