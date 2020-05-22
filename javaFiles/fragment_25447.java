Map<String, String> map = new HashMap<>();
        map.put("a","b");
        map.put("c","d");
        Gson gson = new Gson();
        FileWriter writer = new FileWriter(new File("somefile.json"));
        gson.toJson(map, writer);
        writer.flush();
        writer.close();