ciaoToggleButton.addItemListener(e -> {
    System.out.println("entering");
    JDialog d = new JOptionPane(
            e.getStateChange()==ItemEvent.SELECTED? "selected": "deselected",
            JOptionPane.INFORMATION_MESSAGE)
        .createDialog(panel1, UIManager.getString("OptionPane.messageDialogTitle"));
    d.setModal(false);
    d.setVisible(true);
    System.out.println("leaving");
});