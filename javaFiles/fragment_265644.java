// ...

TableDemo tb  = new TableDemo();  // TableDemo #1. Never displayed

private void initControls() {
    // ...

    TableDemo tablePanel = new TableDemo();   // TableDemo #2

    // ...

    //  TableDemo #2 is here added to the GUI
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tablePanel,panel );

    // ...
}

btnAccept.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        // here you add a row to the non-displayed TableDemo #1
        tb.addRow(new Object[]{"taza",txtName.getText()});
    }
});