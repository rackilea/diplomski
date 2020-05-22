<T> List<LocalizedAttribute<T>> getLocalizedAttributes(List<LocalizedAttribute<B>> localizedAttributes, Function<B,T> mapper) {
    return localizedAttributes.stream()
        .map(localizedAttribute -> {
            Locale locale = localizedAttribute.getLocale();
            B b = localizedAttribute.getValue();
            return new LocalizedAttribute<T>(mapper.apply(b), locale);
        })
        .collect(Collectors.toList());
}