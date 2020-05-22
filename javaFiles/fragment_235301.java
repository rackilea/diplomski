public class WeirdShrinking {
    public static void main(String[] args) {
        JDialog jDialog = new JDialog((JFrame) null, true);

        JPanel content = (JPanel) jDialog.getContentPane();
        content.setLayout(new MigLayout("wrap 1", "[grow]", ""));

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new MigLayout("wrap 1", "[grow]", ""));

        for (int i = 0; i < 5; i++) {
            // *** Change 1, this obviously should be done in a proper class ***
            JPanel panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(1, 1);
                }
            };
            panel.setLayout(new MigLayout("", "[grow]", ""));
            JTextArea description = new JTextArea();
            description.setEditable(false);
            description.setOpaque(false);
            description.setLineWrap(true);
            description.setFont(new Font("Arial", Font.PLAIN, 12));
            description
                    .setText("Lorem ipsum ddsfolor sit amet, consectetur adipiscing elit. Curabitur viverra vehicula fermentum. Sed ac libero ut massa aliquam ornare. Nunc porttitor interdum turpis, porta viverra purus aliquam quis. In dignissim faucibus nunc, non iaculis sapien. In rutrum eleifend pharetra. Aliquam velit dui, pulvinar ut est ut, sagittis congue ligula. Etiam tincidunt varius consequat.");
            // *** Change 2 ***
            panel.add(description, "growx, wmin 10");
            wrapper.add(panel, "growx, wrap");
        }

        content.add(new JScrollPane(wrapper, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), "growx");

        jDialog.setSize(300, 200);
        jDialog.setVisible(true);
    }
}