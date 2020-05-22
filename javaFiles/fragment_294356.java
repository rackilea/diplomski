public class RawHolder {
   @JsonProperty("1")
   public String raw;
}

public class Thing {
   public String name;
   public RawHolder content;
}