private class checkoutListener implements ActionListener{
    private int randomInvoice = Math.round(Math.random() * 10000);

@Override
public void actionPerformed(ActionEvent e) {
    JButton button = (JButton) e.getSource();

    if(button == CheckoutBtn){
        randomInvoice++;
        File file = new File("invoice" + randomInvoice + ".txt");
        file.createNewFile();
        ... // working with file
    }