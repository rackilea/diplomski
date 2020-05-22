try {
        // Read all lines to a List
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        Map<String, List<String>> group = new HashMap<>();

        // Get only IDs -  T0001, T0002 ...
        List<String> t000s = lines.stream()
                .filter(line -> line.startsWith("ZZZZ"))
                .map(line -> line.split(",")[1]) 
                .collect(Collectors.toList());

        // Filter lines by ID
        t000s.forEach(t -> {
            List<String> filtered = lines.stream()
                    .filter(line -> line.contains(t)) 
                    .filter(line -> line.startsWith("CPU") || line.startsWith("ZZZZ"))
                    .collect(Collectors.toList());
            group.put(t, filtered);
        });

    } catch (IOException e) {
        e.printStackTrace();
    }