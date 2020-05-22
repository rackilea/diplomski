Runnable doRun = new Runnable() {

    @Override
    public void run() {
        myComboBox.getEditor().setItem(0);
        myComboBox.getEditor().selectAll();
        myComboBox.requestFocus();
    }
};
SwingUtilities.invokeLater(doRun);