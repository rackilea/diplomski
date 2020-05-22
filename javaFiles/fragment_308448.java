public class OuterClass{
    @JsonProperty("product")
    public Product product;
}

OuterClass outerObject = mapper.readValue(new File("input.txt"), OuterClass.class);