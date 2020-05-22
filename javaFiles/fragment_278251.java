<your bean>
 @JsonDeserialize(using=WhiteSpaceRemovalSerializer.class)
 public void setAString(String aString) {
    // body
 }

 <somewhere>
 public class WhiteSpaceRemovalDeserializer extends JsonDeserializer<String> {
     @Override
     public String deserialize(JsonParser jp, DeserializationContext ctxt) {
         // This is where you can deserialize your value the way you want.
         // Don't know if the following expression is correct, this is just an idea.
         return jp.getCurrentToken().asText().trim();
     }
 }