@Test
public void partial_binding() throws Exception {
    Model model = mapper.readValue(Resources.getResource("partial_binding.json"), Model.class);
    assertThat(model.name, equalTo("xyz"));
    assertThat(model.columns, hasEntry("MEMO_TEXT", "yyy"));
    assertThat(
            mapper.writeValueAsString(model),
            json(jsonObject()
                 .withProperty("Name", "xyz")
                 .withProperty("MEMO_TEXT", "yyy")
                 .withAnyOtherProperties()));
}

public static class Model {
    @JsonProperty
    private int _id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Age")
    private int age;
    private HashMap<String, String> columns;

    @JsonAnyGetter
    public HashMap<String, String> getColumns() {
        return columns;
    }

    public void setColumns(HashMap<String, String> columns) {
        this.columns = columns;
    }

    @JsonAnySetter
    public void putColumn(String key, String value) {
        if (columns == null) columns = new HashMap<>();
        columns.put(key, value);
    }
}