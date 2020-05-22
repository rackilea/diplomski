private class DbResourceResolver implements IResourceResolver {

        @Override
        public InputStream getResourceAsStream(TemplateProcessingParameters params, String resourceName) {

            NotificationTemplate template = templateService.getNotificationTemplateByName(resourceName);
            if (template != null) {
                return new ByteArrayInputStream(template.getFileData());
            }
            return null;
        }

        @Override
        public String getName() {
            return "dbResourceResolver";
        }
    }