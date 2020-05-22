private static ArrayNode getSubFolders(ArrayList<String> values, ObjectMapper mapper, String parent) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        for (String val : values) {
            String currentParent = val.substring(0,val.indexOf("|")).trim();//Parent
            if(currentParent.equals(parent)) {
                String child = val.substring(val.indexOf("|") + 1).trim();//Child
                buildNode(values, mapper, arrayNode, child);
            }

        }
        return arrayNode;
    }