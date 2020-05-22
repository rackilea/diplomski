ObjectMapper mapper = new ObjectMapper();
    try(
            FileReader reader = new FileReader("JsonRead/json2.json");
            BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            String currentLine;
            while((currentLine=bufferedReader.readLine()) != null) {
                Vault vlt = mapper.readValue(currentLine, Vault.class);
                System.out.println(vlt.getBytes());
            } 
        }