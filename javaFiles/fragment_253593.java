public class UpdateWindow extends JFrame {
    private final MainWindow mainWindow;
    public UpdateWindow(MainWindow mainWin) {
        mainWindow = mainWin;
    }
    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {                                      
        quantity = Integer.parseInt(quantityTextField.getText());
        price = Integer.parseInt(priceTextField.getText());
        mainWindow.putDataIntoTable(price,3,2);
    }     
}