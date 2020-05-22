// This pattern can be anywhere in the Class-file:
public static final Pattern POSTFIX_PATTERN = Pattern.compile("tFrame(\\d+)");

// This should be in your exposed GUI class (supposedly the Panel), but can be anywhere it can access headerPanel.
public List<JTextField> findTextFields() {
    List<JTextField> fields = new LinkedList<>();

    Component[] children = headerPanel.getComponents();
    // this is your 'search-loop':
    for (Component child : children) {
        if (child instanceof JTextField) {
            JTextField childField = (JTextField) child;
            String name = childField.getName();
            if (name.startsWith("tFrame")) {
                fields.add(childField);
            }
        }
    }

    return fields;
}