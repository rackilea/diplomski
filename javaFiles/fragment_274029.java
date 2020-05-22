return "CREATE TABLE apis ("
            + Arrays.stream(COLUMN_DATA)
            .map(col -> Arrays.stream(col)
                    .collect(Collectors.joining(" "))
                    )
            .collect(Collectors.joining(", "))
            + ")";