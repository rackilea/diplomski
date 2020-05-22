static class MyRDFNodeRenderer extends DefaultTableCellRenderer {

    public MyRDFNodeRenderer() { super(); }

    public void setValue(Object value) {
        setText((value == null) ? "" : FmtUtils.stringForRDFNode((RDFNode) value));
    }
}