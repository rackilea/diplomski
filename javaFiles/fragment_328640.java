OptionalLong toOptionalLong(Optional<Long> o) {
    return o.map(OptionalLong::of).orElse(OptionalLong.empty());
}
OptionalLong toOptionalLong(Optional<Long> o) {
    return o.isPresent() ? OptionalLong.of(o.get()) : OptionalLong.empty();
}