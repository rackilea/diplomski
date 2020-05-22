@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Foo.class)
    public class Foo {
       @JsonProperty
       Object id;
       @JsonProperty
       Bar bar;
    }

   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Bar.class)
    public class Bar{
       @JsonProperty
       Object id;
       @JsonProperty
       List<Foo> foos;
    }