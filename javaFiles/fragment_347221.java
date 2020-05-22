void search() {
    searchstr = tf_search.getText();
    if (searchstr == null) {
        return;
    }

    aktStr = textarea.getText();
    Index = aktStr.indexOf(searchstr);

    if (Index == -1) {
        JOptionPane.showMessageDialog(null, "String not found", "Dialog", JOptionPane.INFORMATION_MESSAGE);
    } else {
        textarea.requestFocus();
        textarea.select(Index, Index + searchstr.length());
    }
}