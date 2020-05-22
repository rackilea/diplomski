@Bean
public ErrorAttributes errorAttributes() {
    return new DefaultErrorAttributes() {
        @Override
        public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
            Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
            // customize here
            return errorAttributes;
        }

   };
}