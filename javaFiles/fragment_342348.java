@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public static class Person {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private int age;
}