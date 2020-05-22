public class ExpandableGridBagLayout extends GridBagLayout {

    public void setExpand(boolean expanded) {
        for (Map.Entry<Component, GridBagConstraints> entry : comptable.entrySet()) {
            setExpandedMargin(entry.getKey(), entry.getValue(), expanded);
        }
    }

    private void setExpandedMargin(Component component, GridBagConstraints constraints, boolean expanded) {
        constraints.insets.right = 2;
        if (component instanceof JLabel) {
            constraints.insets.top = expanded ? 3 : 0;
            constraints.insets.bottom = expanded ? 3 : 0;
        } else {
            constraints.insets.bottom = expanded ? 8 : 5;
        }
    }
}