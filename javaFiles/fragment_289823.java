public class DocumentService {

  public JsonDocument saveDocument(JsonDocument document){
    UUID uuid = UUID.randomUUID();
    document.setId(uuid.toString());
    return document;
  }
}