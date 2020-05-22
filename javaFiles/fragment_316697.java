@JsonTypeResolver(MyTypeResolver.class)
@JsonTypeIdResolver(MyTypeIdResolver.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public interface ObjectMixin {

}

ObjectMapper mapper = new ObjectMapper();
mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
mapper.addMixIn(Object.class, ObjectMixin.class);