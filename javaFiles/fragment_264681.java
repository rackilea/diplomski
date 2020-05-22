// serialize pane and save object to file in the JSON format
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.writeValue(new File("target/pane.json"), pane);

// load object from file and deserialize it to ItemStack
ItemStack pane2 = objectMapper.readValue(new URL("file:src/test/resources/pane.json"), ItemStack.class);