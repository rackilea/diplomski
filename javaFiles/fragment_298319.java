@Override
public Editable getText() {
    CharSequence text = super.getText();
    // This can only happen during construction.
    if (text == null) {
        return null;
    }

    [rest of code removed for clarity]
}