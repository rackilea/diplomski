public class Baz {

    @JsonSerialize(using = MapToArraySerializer.class)
    @JsonDeserialize(using = ArrayToMapDeserializer.class,
        keyAs = Foo.class, contentAs = Bar.class)
    Map<Foo, Bar> map;

}