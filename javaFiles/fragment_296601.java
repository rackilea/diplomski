for (Map.Entry<String, JsonNode> elt : rootNode.fields())
{
    if ("foo".equals(elt.getKey()))
    {
        // bar
    }
}