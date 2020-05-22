private static JsonNode attachmentConversion(JsonNode object){



    final String ATTACHMENT_POINTER = "/RESULTS/ATTACHMENTS/ATTACHMENT"; //Path to the array
    ObjectNode OUTPUT = object.deepCopy();
    OUTPUT.remove("DETAILS");

    //Validate is an array - It properly fetches the array
    if(OUTPUT.at(ATTACHMENT_POINTER).isArray()){
        int counter=0;

        //Loop through attachment array - It properly fethes each object in the array
        for(final JsonNode objNode : OUTPUT.at(ATTACHMENT_POINTER)){
            ((ObjectNode)objNode).replace("ATTACH_CONTENT", xmlToJson.parseXmlToJson(objNode.get("ATTACH_CONTENT"));
        }

    }
    return new ObjectMapper()
            .createObjectNode()
            .set("customertopology", OUTPUT);
}