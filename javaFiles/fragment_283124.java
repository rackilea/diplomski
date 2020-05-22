String json = "{\n" +
              "  \"skills\": {\n" +
              "    \"skillSet\": [\n" +
              "      {\n" +
              "        \"skill\": \"Management\"\n" +
              "      },\n" +
              "      {\n" +
              "        \"skill\": \"IT\"\n" +
              "      }\n" +
              "    ]\n" +
              "  }\n" +
              "}";

// Create ObjectMapper instance to parse the JSON
ObjectMapper mapper = new ObjectMapper();

// Parse the JSON into the Jackson tree model
JsonNode tree = mapper.readTree(json);

// Store a reference to the "skills" node
JsonNode skills = tree.get("skills");

// Store a reference to the "skillsSet" node
JsonNode skillSet = skills.get("skillSet");

// Remove the "skillsSet" node from the tree
((ObjectNode) skills).remove("skillSet");

// Create the "skillSet" node under "mainSkills" 
// and sets it under the "skills" node
((ObjectNode) skills).set("mainSkills", 
        mapper.createObjectNode().set("skillSet", skillSet));

// Write the tree as a JSON string using the default pretty printer
String newJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);