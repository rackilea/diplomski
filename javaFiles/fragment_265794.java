JComponent panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
panel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
initContent(panel);

// in initContent
JPanel infopanel = new JPanel() {

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }


};
infopanel.setBorder(BorderFactory.createLineBorder(Color.RED));
infopanel.setAlignmentY(0f);
infopanel.setLayout(new BoxLayout(infopanel, BoxLayout.Y_AXIS));
JPanel listpanel = new JPanel();
listpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
listpanel.setAlignmentY(0f);
listpanel.setLayout(new GridLayout(0,1,5,5));