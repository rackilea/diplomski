public class TemplateHelper {
    private static final XLogger logger = XLoggerFactory.getXLogger(TemplateHelper.class);
    private MessageSource messageSource;
    private VelocityEngine velocityEngine;

    public String merge(String templateLocation, Map<String, Object> data, Locale locale) {
        logger.entry(templateLocation, data, locale);

        if (data == null) {
            data = new HashMap<String, Object>();
        }

        if (!data.containsKey("messages")) {
            data.put("messages", this.messageSource);
        }

        if (!data.containsKey("locale")) {
            data.put("locale", locale);
        }

        String text =
            VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine,
                templateLocation, data);

        logger.exit(text);

        return text;
    }
}