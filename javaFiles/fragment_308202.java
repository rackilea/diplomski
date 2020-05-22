Map<String, Outer> OutersById = Arrays.stream(outers)
                .collect(
                        Collectors.toMap(
                                outer -> outer.inner.id, 
                                outer -> outer,
                                (a, b) -> a.hashCode() > b.hashCode() ? a : b
                                ));