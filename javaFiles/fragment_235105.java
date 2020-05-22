public class MessageSourcePropertyEditor extends PropertyEditorSupport {

    private MessageSourceAccessor messageSourceAccessor;

    public MessageSourcePropertyEditor(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String value = text;

        if (text.startsWith("i18n:")) {
            value = messageSourceAccessor.getMessage(text.substring(5));
        }

        setValue(value);
    }
}

public class MessageEditorRegistrar implements PropertyEditorRegistrar {

    private MessageSource messageSource;

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(String.class, new MessageSourcePropertyEditor(messageSource));

    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}