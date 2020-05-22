Path wipPath = Paths.get("/Users/chappa/Documents/items.json");
        try (BufferedReader reader = Files.newBufferedReader(wipPath)) {
            String line=null;
            while((line = reader.readLine()) != null) {
                    System.out.println(line);
            }
        }