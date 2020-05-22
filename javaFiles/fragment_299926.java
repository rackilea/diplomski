@Component
public class JsonValidator {

  private final ObjectMapper objectMapper = new ObjectMapper();

  public boolean isValid(String value) {
    try {
      objectMapper.readTree(value);
      return true;
    } catch (JsonProcessingException e) {
      return false;
    }
  }
}