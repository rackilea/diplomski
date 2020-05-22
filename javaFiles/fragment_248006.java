class DepositListener implements ActionListener {
    private MainFrame mainFrame;

    public DepositListener(MainFrame mainFrame) {
       this.mainFrame = mainFrame;
    }

    public void actionPerformed(ActionEvent event) {

        // you'll need to give MainFrame public methods to extract information, e.g.,
        double depositAmount = Double.parseDouble(mainFrame.getAmount());
        // ... etccc

        // and to display information
        mainFrame.setBalanceText(....);

    }
}