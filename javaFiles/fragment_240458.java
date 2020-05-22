@Bean
public WebMvcTagsProvider webMvcTagsProvider() {
    return new WebMvcTagsProvider() {
        @Override
        public Iterable<Tag> getTags(HttpServletRequest request, HttpServletResponse response, Object handler, Throwable exception) {
            return ((Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE))
                    .entrySet()
                    .stream()
                    .map(entry -> new ImmutableTag(entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
        }

        @Override
        public Iterable<Tag> getLongRequestTags(HttpServletRequest request, Object handler) {
            return new ArrayList<>();
        }
    };
}