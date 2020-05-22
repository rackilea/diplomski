public class TransparentTabs extends JFrame {

    private final static Color TRANSPARENT = new Color(0, 0, 0, 0);

    TransparentTabs() {

        JTabbedPane tabs = new JTabbedPane();

        JLabel label = new JLabel("Text Here");
        label.setOpaque(true);
        label.setBackground(TRANSPARENT);

        tabs.addTab(null, new ImageIcon("path to image"), label); // Change path
        tabs.addTab("Tab to the left has only an image", new JLabel("Something"));
        tabs.setSelectedIndex(-1);

        getContentPane().setBackground(Color.RED); // Placeholder for background image
        getContentPane().add(tabs);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

    UIManager.put("TabbedPane.contentAreaColor", TRANSPARENT);
    UIManager.put("TabbedPane.selected", TRANSPARENT);
    UIManager.put("TabbedPane.background", TRANSPARENT);
    UIManager.put("TabbedPane.borderHightlightColor", TRANSPARENT);
    UIManager.put("TabbedPane.darkShadow", TRANSPARENT);
    UIManager.put("TabbedPane.focus", TRANSPARENT);

        new TransparentTabs();
    }
}