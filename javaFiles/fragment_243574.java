/**
 * Enables (or disables) the button.
 * @param b  true to enable the button, otherwise false
 */
public void setEnabled(boolean b) {
    if (!b && model.isRollover()) {
        model.setRollover(false);
    }
    super.setEnabled(b);
    model.setEnabled(b);
}