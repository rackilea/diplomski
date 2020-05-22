public class DefaultTreeTableRenderer
    extends AbstractRenderer
    implements TableCellRenderer
{

    private TableCellContext cellContext;

    /**
     * Instantiates a default table renderer with the default component provider.
     * 
     * @see #DefaultTableRenderer(ComponentProvider)
     */
    public DefaultTreeTableRenderer()
    {
        this((ComponentProvider<?>)null);
    }

    /**
     * Instantiates a default table renderer with the given component provider. If the controller is null, creates
     * and uses a default. The default provider is of type <code>LabelProvider</code>.
     * 
     * @param componentProvider the provider of the configured component to use for cell rendering
     */
    public DefaultTreeTableRenderer(ComponentProvider<?> componentProvider)
    {
        super(componentProvider);
        this.cellContext = new TableCellContext();
    }

    /**
     * Instantiates a default table renderer with a default component provider using the given converter.
     * 
     * @param converter the converter to use for mapping the content value to a String representation.
     * @see #DefaultTableRenderer(ComponentProvider)
     */
    public DefaultTreeTableRenderer(StringValue converter)
    {
        this(new LabelProvider(converter));
    }

    /**
     * Instantiates a default table renderer with a default component provider using the given converter and
     * horizontal alignment.
     * 
     * @param converter the converter to use for mapping the content value to a String representation.
     * @see #DefaultTableRenderer(ComponentProvider)
     */
    public DefaultTreeTableRenderer(StringValue converter, int alignment)
    {
        this(new LabelProvider(converter, alignment));
    }

    /**
     * Intantiates a default table renderer with default component provider using both converters.
     * 
     * @param stringValue the converter to use for the string representation
     * @param iconValue the converter to use for the icon representation
     */
    public DefaultTreeTableRenderer(StringValue stringValue, IconValue iconValue)
    {
        this(new MappedValue(stringValue, iconValue));
    }

    /**
     * Intantiates a default table renderer with default component provider using both converters and the given
     * alignment.
     * 
     * @param stringValue the converter to use for the string representation
     * @param iconValue the converter to use for the icon representation
     * @param alignment the rendering component's horizontal alignment
     */
    public DefaultTreeTableRenderer(StringValue stringValue, IconValue iconValue, int alignment)
    {
        this(new MappedValue(stringValue, iconValue), alignment);
    }

    // -------------- implements javax.swing.table.TableCellRenderer
    /**
     * Returns a configured component, appropriate to render the given list cell.
     * <p>
     * Note: The component's name is set to "Table.cellRenderer" for the sake of Synth-based LAFs.
     * 
     * @param table the <code>JTable</code>
     * @param value the value to assign to the cell at <code>[row, column]</code>
     * @param isSelected true if cell is selected
     * @param hasFocus true if cell has focus
     * @param row the row of the cell to render
     * @param column the column of the cell to render
     * @return the default table cell renderer
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column)
    {
        boolean expanded = true;
        boolean leaf = true;
        if (table instanceof JXTreeTable)
        {
            JXTreeTable treeTable = (JXTreeTable)table;
            expanded = treeTable.isExpanded(row);
        }
        this.cellContext.installContext(table, value, row, column, isSelected, hasFocus, expanded, leaf);
        Component comp = this.componentController.getRendererComponent(this.cellContext);
        // fix issue #1040-swingx: memory leak if value not released
        this.cellContext.replaceValue(null);
        return comp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ComponentProvider<?> createDefaultComponentProvider()
    {
        return new LabelProvider();
    }

}