private static class CustomTemplateResolver implements IResourceResolver {
        private InputStream inputStream;
        private String templateName;

        public CustomTemplateResolver(String templateName, InputStream inputStream) {
            this.templateName = templateName;
            this.inputStream = inputStream;
        }

        @Override
        public String getName() {
            return templateName;
        }

        @Override
        public InputStream getResourceAsStream(TemplateProcessingParameters templateProcessingParameters, String resourceName) {
            return inputStream;
        }
    }