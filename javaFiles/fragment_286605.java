public class DefaultLayouts {
    public static JLabel infoLabel(String text) {
        JLabel label = new JLabel(text);

        Border margin = new EmptyBorder(10, 10, 10, 10);
        Border border = label.getBorder();
        label.setBorder(new CompoundBorder(border, margin));

        return label;
    }
}