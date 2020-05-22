@Data
@NoArgsConstructor
private class Response{
    @JsonProperty("someField")
    private int someField;
    @JsonProperty("datesField")
    private String[] datesField;
}