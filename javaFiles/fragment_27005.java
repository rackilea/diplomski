class InventoryItemPanel extends JPanel {
    Car car;

    // Button button = new Button("View More Details"); // should be a JButton
    JButton button = new JButton("View More Details"); // should be a JButton

    public InventoryItemPanel(Car car) {

        this.car = car;

        // executes ButtonActionPerformed when button is clicked.
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });
        add(button);

    }

    public void ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // new ViewCarPanel(car).setVisible(true);

        // get current JFrame
        Window thisJFrame = SwingUtilities.getWindowAncestor(this);
        // Create a non-modal JDialog
        JDialog dialog = new JDialog(thisJFrame, "Car Make", ModalityType.MODELESS);
        // create new viewCarPanel
        ViewCarPanel viewCarPanel = new ViewCarPanel(car);
        // add to dialog
        dialog.add(viewCarPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(thisJFrame);
        dialog.setVisible(true);
    }
}