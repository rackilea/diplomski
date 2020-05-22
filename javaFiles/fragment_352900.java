@Configuration
public class MessageConfig {

    private final MessageSource source;
    private final MessageSourceAccessor accessor;


    @Autowired
    public MessageConfig(MessageSource messageSource) {
        this.accessor = new MessageSourceAccessor(this.source = messageSource, new Locale("de", "DE"));
    }


    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(this.source);
        return factory;
    }

    public String get(String msg) {
        try {
            Assert.hasText(msg, "message code must be not blank");
            return this.accessor.getMessage(msg.trim());
        } catch (NoSuchMessageException e) {
            return '{' + msg + '}';
        }
    }
}