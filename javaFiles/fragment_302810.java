@JsonDeserialize(builder = Address.Builder.class)
public class Address
{
  private Address(Map<LocationType, String> components)
  ...

  @JsonPOJOBuilder(buildMethodName = "create", withPrefix = "set")
  public static class Builder
  {
    public Builder setCity(String value);
    public Builder setCountry(String value);
    public Address create();
  }
}