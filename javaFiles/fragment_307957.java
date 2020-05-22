final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

ActionListener actionListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        for(int i = 0; i < tabbedPane.getTabCount(); i++) {
            if(SwingUtilities.isDescendingFrom(button, tabbedPane.getTabComponentAt(i))) {
                tabbedPane.remove(i);
                break;
            }
        }
    }
};

JLabel label = new JLabel("Tab1", UIManager.getIcon("OptionPane.informationIcon"), JLabel.RIGHT);        
JButton closeButton = new JButton("X");
closeButton.addActionListener(actionListener);

JPanel tabComponent = new JPanel(new BorderLayout());
tabComponent.add(label, BorderLayout.WEST);
tabComponent.add(closeButton, BorderLayout.EAST);

tabbedPane.addTab(null, new JPanel());
tabbedPane.setTabComponentAt(0, tabComponent); // Here set the custom tab component