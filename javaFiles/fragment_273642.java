public class MapConverter implements Converter<HashMap<String, Integer>> {
   @Override
   public HashMap<String, Integer> read(InputNode inputNode) throws Exception {
      final HashMap<String, Integer> result = new HashMap<String, Integer>();

      for (final String attributeName : inputNode.getAttributes()) {
         final String value = inputNode.getAttribute(attributeName).getValue();
         result.put(attributeName, Integer.parseInt(value));
      }

      return result;
   }

   @Override
   public void write(OutputNode outputNode, HashMap<String, Integer> stringIntegerHashMap)
         throws Exception {
      // not used
   }
}