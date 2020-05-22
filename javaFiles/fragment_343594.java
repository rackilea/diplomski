@Tags({"greeting", "2letters"})
@Bean
public Supplier<String> hi() {
    return () -> "hi";
}

@Tags({"parting", "2letters"})
@Bean
public Supplier<String> by() {
    return () -> "by";
}

@Tags("greeting")
@Bean
public Supplier<String> hello() {
    return () -> "hello";
}

@Tags("parting")
@Bean
public Supplier<String> goodbye() {
    return () -> "goodbye";
}

@Tags("other")
@Bean
public Supplier<String> other() {
    return () -> "other";
}