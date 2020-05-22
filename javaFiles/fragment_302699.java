public void openComportButtonActionPerformed(java.awt.event.ActionEvent evt)  {
    String port = (String)comPortcomboBox.getSelectedItem();
    String rate = (String)baudRatecomboBox.getSelectedItem();
    if (port != null && rate != null) {
        try {
            twoWaySerCom.connect(portName, rate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}