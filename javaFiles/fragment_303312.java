ciaoToggleButton.addItemListener(e -> {
    System.out.println("entering");
    JOptionPane.showMessageDialog(panel1,
       e.getStateChange()==ItemEvent.SELECTED? "selected": "deselected");
    System.out.println("leaving");
});