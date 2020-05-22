public class RootJson {
    @JsonSerialize(using = JsonMyDateSerializer.class)
    @JsonDeserialize(using = JsonMyDateDeserializer.class)
   private MyDate myDate;
   private String id;
}