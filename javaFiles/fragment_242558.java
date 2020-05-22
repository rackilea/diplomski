public void processStrings() {
        Map<String, Properties> dataMap = new TreeMap<String, Properties>(); 
        StringParsing parsing = new StringParsing();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "dataFile.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                Properties p = parsing.parseString(line);
                dataMap.put(p.getProperty("M:"), p);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }