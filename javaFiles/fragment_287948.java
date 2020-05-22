String input = "your data";
JsonParser parser = new JsonParser();
JsonObject o = parser.parse(input).getAsJsonObject();

try {
   String foundValue = o.getAsJsonPrimitive("fruit").getAsString();
   if ("apple".equals(foundValue)) {
      o.remove("fruit");
   }
} catch (Exception e) {
  e.printStackTrace();
}
String filteredData = o.toJSONString();