List<Class<?>> classes = Stream.of("java.lang.Object", "java.lang.Integer", "java.lang.String")
            .map(className -> {
                try {
                    return Class.forName(className);
                } catch (Exception e) {
                    throw new YourRuntimeException();
                }
            })
            .collect(Collectors.toList());