public class MyInnerListener implements ListSelectionListener {

    private JList list;

    public MyInnerListener(JList list) {

        this.list = list;

    }
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            CardLayout.show(infoPanel, (String)list.getSelectedValue());
        }
    }

}