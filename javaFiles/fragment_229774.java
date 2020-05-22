String[] resArray = Files.readAllLines(f.toPath()).stream()
                         .map(s -> s.split(",")[0])   
                         .toArray(String[]::new);
// or
List<String> resList = Files.readAllLines(f.toPath()).stream()
                            .map(s -> s.split(",")[0])
                            .collect(Collectors.toCollection(ArrayList::new));