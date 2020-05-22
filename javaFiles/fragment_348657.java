try (
            final Stream<String> lines = Files.lines(txt);
            final PrintWriter pw = new PrintWriter(newBufferedWriter(csv, StandardOpenOption.CREATE_NEW))) {
        lines.map((line) -> line.split("\\|")).
                map((line) -> Stream.of(line).collect(joining(","))).
                forEach(pw::println);
    }