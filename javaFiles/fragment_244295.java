public class TabComponent extends JPanel {

    private CloseIcon closeIcon;

    public TabComponent(String title) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        JLabel lblTitle = new JLabel(title);
        closeIcon = new CloseIcon();
        closeIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireTabEvent(new TabEvent(this));//, TabEvent.TAB_CLOSING));
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblTitle, gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(closeIcon);

    }

    public void addTabEventListener(TabEventListener listener) {
        listenerList.add(TabEventListener.class, listener);
    }

    public void removeTabEventListener(TabEventListener listener) {
        listenerList.remove(TabEventListener.class, listener);
    }

    protected void fireTabEvent(TabEvent evt) {
        Object[] listeners = listenerList.getListeners(TabEventListener.class);
        for (int i = 0, n = listeners.length; i < n; i++) {
            ((TabEventListener) listeners[i]).handleEvent(evt);
        }
    }

}