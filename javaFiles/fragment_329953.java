ListSelectionListener sl = new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        JList candyList = (JList)e.getSource();
        if (e.getValueIsAdjusting() == false) {
            CardLayout.show(infoPanel, (String)candyList.getSelectedValue());
        }
       }
    };