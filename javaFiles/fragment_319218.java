SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        toEdit.setText(toEdit.getText() + letter);
    }
}