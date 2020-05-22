StringBuilder reduced
                = beans.stream()
                .map(b -> new StringBuilder(b.getName()))
                .reduce(new StringBuilder(), (builder, name) -> {
                    if (builder.length() > 0) {
                        builder.append(", ");
                    }

                    builder.append(name);
                    return builder;
                }/* WITHOUT THIRD PARAM*/);