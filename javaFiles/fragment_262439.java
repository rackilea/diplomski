@Mapping(source = "child", target = "kid", qualifiedByName = "unwrap")
Target map(Source source);

@Named("unwrap")
default <T> T unwrap(Optional<T> optional) {
    return optional.orElse(null);
}