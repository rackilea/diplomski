public @interface MyAnnotation {

    @JsonGetter(value = "name")
    String name();

    @JsonGetter(value = "age")
    Integer age();
}