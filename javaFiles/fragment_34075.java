JXTable table = new JXTable(myModel);
AbstractHyperlinkAction<Object> simpleAction = new AbstractHyperlinkAction<Object>(null) {

    public void actionPerformed(ActionEvent e) {
        // here goes what you want to do on activating the hyperlink
        //LOG.info("hit: " + getTarget());
    }

};
TableCellRenderer renderer = new DefaultTableRenderer(
    new HyperlinkProvider(simpleAction));
table.getColumnExt(0).setEditable(false);
table.getColumnExt(0).setCellRenderer(renderer);