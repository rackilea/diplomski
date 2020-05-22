String json = " [{ image_url:\"www\", testimonial_text: \"The standard chunk of Lorem Ipsum used since the\", name: \"Rohith\", designation: \"Architect\" }, "
            + "{ image_url:\"www\", testimonial_text: \"The standard chunk of Lorem Ipsum used since\", name: \"Rohith\", designation: \"Architect\" }]";

    byte[] jsonData = json.getBytes();

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

    // create JsonNode
    JsonNode rootNode = objectMapper.readTree(jsonData);

    ObjectNode createDesignationNode = objectMapper.createObjectNode();
    Iterator<JsonNode> iterator = rootNode.iterator();

    while (iterator.hasNext()) {
        JsonNode jsonNode = (JsonNode) iterator.next();
        createDesignationNode.put("designation", jsonNode.get("designation"));

        ArrayNode createData2Array = objectMapper.createArrayNode();
        createData2Array.add(createDesignationNode);

        ((ObjectNode) jsonNode).remove("designation");
        ((ObjectNode) jsonNode).put("data2", createData2Array);

    }

    PrintStream out = System.out;
    objectMapper.writeValue(out, rootNode);