@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@JacksonAnnotationsInside
@JsonSerialize(using = XSerializer.class)
@JsonDeserialize(using = XDeserializer.class)
public @interface MyAnnotation {
}