public class DefaultTextBox extends TextBox {

    /**
     * The text color used when the box is disabled and empty.
     */
    private static final String TEXTBOX_DISABLED_COLOR = "#AAAAAA";

    private final String defaultText;

    public @UiConstructor
    DefaultTextBox(final String defaultText) {
        this.defaultText = defaultText;
        resetDefaultText();

        // Add focus and blur handlers.
        addFocusHandler(new FocusHandler() {
            @Override
            public void onFocus(FocusEvent event) {
                getElement().getStyle().clearColor();
                getElement().getStyle().clearFontStyle();
                if (defaultText.equals(getText())) {
                    setText("");
                }
            }
        });

        addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                if ("".equals(getText())) {
                    resetDefaultText();
                }
            }
        });
    }

    public String getDefaultText() {
        return defaultText;
    }

    @Override
    public void setText(String text) {
        if (text == null) {
            super.setText(getDefaultText());
        } else {
            getElement().getStyle().clearColor();
            getElement().getStyle().clearFontStyle();
            super.setText(text);
        }
    }

    public String getText() {

        return super.getText();
    }

    /**
     * This is override so that the editor framework will not get the default
     * value but the actual null value when the default text is in the box.
     */
    @Override
    public String getValue() {
        try {
            return getValueOrThrow();
        } catch (ParseException e) {
            return null;
        }

    }

    @Override
    public void setValue(String value) {
        setText(value);
    }

    /**
     * This is overridden from the parent class because this is 
     * how the editor gets the value.
     */
    public String getValueOrThrow() throws ParseException {
        if (defaultText.equals(super.getValueOrThrow())) {
            return null;
        }
        return super.getValueOrThrow();
    }


    /**
     * Reset the text box to the default text.
     */
    public void resetDefaultText() {
        setText(defaultText);
        getElement().getStyle().setColor(TEXTBOX_DISABLED_COLOR);
        getElement().getStyle().setFontStyle(FontStyle.ITALIC);
    }
}