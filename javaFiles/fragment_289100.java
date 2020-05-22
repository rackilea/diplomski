Path wipPath = Paths.get("/Users/chappa/Documents/items.json");
try (BufferedWriter writer = Files.newBufferedWriter(wipPath)) {
            for (String record : nosRecords) {
                writer.write(record);
            }
        }