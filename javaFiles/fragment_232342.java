JsonObjectBuilder builder = Json.createObjectBuilder(); 
   builder.add("Item", item); 
   builder.add("Choice 1", idchoice1); 
   builder.add("Choice 2", idchoice2);
   builder.add("Choice 3", idchoice3);
   JsonObject jo = builder.build();
   try { 
        Map<String, Object> properties = new HashMap<>(1);
        properties.put(JsonGenerator.PRETTY_PRINTING, true);
        FileWriter fw = new FileWriter("SelectedChoice.txt", true);
        JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
        JsonWriter jsonWriter = writerFactory.createWriter(fw);
        jsonWriter.writeObject(jo);
        jsonWriter.close(); 
        fw.close(); 
    } catch (IOException e) { 
        e.printStackTrace(); 
    }