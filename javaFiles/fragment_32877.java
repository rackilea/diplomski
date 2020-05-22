public class MenuPane extends JPanel {

    public MenuPane() {
        setLayout(new GridBagLayout());
    }

    public void addSubMenuPane(SubMenuPane pane) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        add(pane, gbc);

        revalidate();
        repaint();
    }

    public void removeSubMenu(SubMenuPane pane) {
        remove(pane);
        revalidate();
        repaint();
    }

    public void popLastMenu() {
        if (getComponentCount() == 1) {
            return;
        }
        remove(getComponent(getComponentCount() - 1));
        revalidate();
        repaint();
    }

}

public class SubMenuPane extends JPanel {

    public SubMenuPane(String name) {
        setLayout(new GridLayout(0, 1));
        setBorder(new LineBorder(Color.DARK_GRAY));
        add(new JLabel(name, JLabel.CENTER));
    }

    public SubMenuPane addAction(MenuAction action) {
        JButton btn = new JButton(action);
        add(btn);
        return this;
    }

}