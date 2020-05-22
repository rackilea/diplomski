private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    //show card 1 from here
    CardLayout card = (CardLayout) this.getParent().getLayout();
    card.show((JPanel) this.getParent(), "card1");

    //card1 shown, show specific tab in the tab pane from here:

    NewJFrame parent = (NewJFrame) this.getParent();
    ((JPanelCard1) parent.getJPanelCard11()).setTab(1);
}