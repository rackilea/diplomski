public static void setEnabledRecursive(Composite composite, boolean enabled) {
    Check.notNull(composite, "composite"); //$NON-NLS-1$

    for (Control control : composite.getChildren()) {
        if (control instanceof Composite) {
            setEnabledRecursive((Composite) control, enabled);
        } else {
            control.setEnabled(enabled);
        }
    }
    composite.setEnabled(enabled);
}