private class MyPOJO {
    public String target;
    @JsonProperty("placeholder_id")
    public String placeholder;

    public MyPOJO(String target, String placeholder) {
        this.target = target;
        this.placeholder = placeholder;
    }
}

ObjectMapper mapper = new ObjectMapper();
MyPOJO data = mapper.readValue(yourJsonString, MyPOJO.class);

System.out.println(data.target);