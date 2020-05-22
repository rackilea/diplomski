@Bean
public TagsFactoryBean words() {
    return TagsFactoryBean.<Supplier>builder()
            .tags("greeting", "other")
            .type(Supplier.class)
            .generics(String.class)
            .build();
}