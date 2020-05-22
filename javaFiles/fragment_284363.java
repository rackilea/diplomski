public static class MyTableHeader extends JTableHeader {
    private EventHook hook;
    public MyTableHeader(TableColumnModel model) {
        super(model);
    }
    @Override
    public void updateUI() {
        if (hook != null) {
            hook.uninstallHook();
            hook = null;
        }
        super.updateUI();
        hook = new EventHook(this);
    }

}