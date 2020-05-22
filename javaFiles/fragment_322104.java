void deleteProperty(JsonNode root, List<String> propPath)
{
   JsonNode node = root;

   for (String propName: propPath.subList(0, propPath.size() - 1)) {
       node = node.findPath(propName);
   }
   // completely ignore missing properties
   if ((! node.isMissingNode()) && (! node.isEmpty())) {
       if (node instanceof ObjectNode) {
           final ObjectNode parent = (ObjectNode)node;
           parent.remove(propPath.get(propPath.size() - 1));
       }
   }
}