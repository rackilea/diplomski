public class Kunden {
  private List<Kunde> kunden;
  // getter and setter
}

Kunden root = new Kunden();
kunden.setKunden(...);

JsonNode rootNode = Json.toJson(root);
ObjectMapper mapper = new ObjectMapper(); 
String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);