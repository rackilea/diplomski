public static Map<String, String> getMapFromCSV(final String filePath) throws IOException{

        Stream<String> lines = Files.lines(Paths.get(filePath));
        Map<String, String> resultMap = 
                lines.map(line -> line.split(","))
                     .collect(Collectors.toMap(line -> line[0], line -> line[1]));

        lines.close();

        return resultMap;
    }