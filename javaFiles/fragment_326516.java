public static ObjectMapper createObjectMapper() {

    final ObjectMapper mapper = new ObjectMapper();
    mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {

        @Override
        public JsonPOJOBuilder.Value findPOJOBuilderConfig(final AnnotatedClass ac) {
            if (ac.hasAnnotation(JsonPOJOBuilder.class)) {
                return super.findPOJOBuilderConfig(ac);
            }
            return new JsonPOJOBuilder.Value("build", "");
        }
    });

    return mapper;
}

public static void main(final String[] args) throws Exception {
    final ObjectMapper objectMapper = createObjectMapper();

    final String serializedForm = objectMapper.writeValueAsString(SubA.builder().build());
    System.out.println(serializedForm);
    final SubA anA = objectMapper.readValue(serializedForm, SubA.class);
    System.out.println(anA);
}


@Getter
@EqualsAndHashCode(callSuper = true)
@Accessors(fluent = true, chain = true)
@SuperBuilder
@JsonDeserialize(builder = SubA.SubABuilderImpl.class)
@JsonTypeName("SubA")
public static class SubA extends AbstractA {

    @JsonProperty
    private final String fieldA;
}


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = SubA.class)
})
@Getter
@Accessors(fluent = true, chain = true)
@SuperBuilder
public static abstract class AbstractA {

    @JsonProperty
    protected final String superProperty;
}