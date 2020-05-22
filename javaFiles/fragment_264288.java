public static class XComboBox extends JComboBox {

    private ListSelectionListener listener;

    public XComboBox() {
        uninstall();
        install();
    }

    @Override
    public void updateUI() {
        uninstall();
        super.updateUI();
        install();
    }

    private void uninstall() {
        if (listener == null) return;
        getPopupList().removeListSelectionListener(listener);
        listener = null;
    }

    protected void install() {
        listener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;

                JList list = getPopupList();
                System.out.println("--> " + String.valueOf(list.getSelectedValue()));
            }
        };
        getPopupList().addListSelectionListener(listener);
    }

    private JList getPopupList() {
        ComboPopup popup = (ComboPopup) getUI().getAccessibleChild(this, 0);
        return popup.getList();

    }
}