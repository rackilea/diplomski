class JXXTable extends JXTable {
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    HighlightPredicate predicate = new HighlightPredicate(){
        public boolean isHighlighted(Component renderer, ComponentAdapter adapter) {
            return adapter.hasFocus();
        }
    };
    Highlighter cellHighlight = new ColorHighlighter(predicate, null, null, new Color(115,164,209), Color.WHITE);

    public JXXTable(CustomTableModel model){ 
        super(model); 
        this.setDefaultRenderer(Object.class, renderer);
    }
    public void Paint(){
        this.setDefaultRenderer(Object.class, renderer);
        this.setHighlighters();
        this.addHighlighter(cellHighlight); 
    }
}