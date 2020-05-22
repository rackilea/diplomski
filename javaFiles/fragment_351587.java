List<String> cities = new ArrayList<String>();
    cities.addAll(Arrays.asList("Boston", "Washington", "Irving", "Dallas"));

    //Get the file reference
    Path path = Paths.get("C:\\apps\\output.txt");

    //Use try-with-resource to get auto-closeable writer instance
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
        cities.forEach(city -> {
            try {
                writer.write(city);
                writer.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    } catch (IOException e) {
        e.printStackTrace();
    }
}