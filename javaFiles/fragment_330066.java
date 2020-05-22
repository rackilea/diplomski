JXTree tree = new JXTree();
tree.expandAll();
IconValue iv = new IconValue() {

    Icon icon = XTestUtils.loadDefaultIcon("green-orb.png");
    @Override
    public Icon getIcon(Object value) {
        return value.toString().contains("s") ? icon : null;
    }

};
StringValue converter = new MappedValue(StringValues.TO_STRING, iv);
WrappingProvider provider = new WrappingProvider(IconValues.NONE, converter);
// hacking around missing api ...
LabelProvider wrappee = (LabelProvider) provider.getWrappee();
wrappee.getRendererComponent(null).setHorizontalTextPosition(JLabel.LEADING);
TreeCellRenderer r = new DefaultTreeRenderer(provider);
tree.setCellRenderer(r);