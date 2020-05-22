Map<String, Long> freq = null;
        try {
        freq = Files.lines(Path.of("testfile.txt"))
                .flatMap(line -> Arrays.stream(line.split("")))
                .filter(str -> str.length() > 0)
                .collect(Collectors.groupingBy(chr -> chr,
                        Collectors.counting()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }