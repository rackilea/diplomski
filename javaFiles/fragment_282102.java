private static void buildNode(ArrayList<String> values, ObjectMapper mapper, ArrayNode arrayNode, String parent) {
            ObjectNode rootNode = mapper.createObjectNode();

            rootNode.put("folder", parent);
            ArrayNode arrayNodeSubFolder = getSubFolders(values, mapper, parent);
            if(arrayNodeSubFolder.size() != 0)
                rootNode.put("subfolders", arrayNodeSubFolder);

            arrayNode.add(rootNode);
        }