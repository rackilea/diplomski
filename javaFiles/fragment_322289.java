OptionalInt max = lines.parallelStream()
    .mapToInt(line -> {
        int[] b = lineToInst(line);
        ...
        return sum;
    }).max();