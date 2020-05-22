// create object mapper
    com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    // write object to file
    Block block = new SomeBlockImpl();
    File outputFile = new File("output location goes here");
    objectMapper.writeValue(outputFile, block);

    // read object from file
    File inputFile = new File("input location goes here");
    Block savedBlock = objectMapper.readValue(inputFile, Block.class);