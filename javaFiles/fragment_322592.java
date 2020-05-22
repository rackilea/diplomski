@Named
@ViewScoped
public class TestBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static enum Value
    {
        ONE, TWO, THREE;

        public String getName()
        {
            return name().toLowerCase();
        }

        @Override
        public String toString()
        {
            return name();
        }
    }

    private boolean showAll = false;
    private int first = 0;
    private int rows = 2;
    private List<Value> fullList = Arrays.asList(Value.values());
    private List<Value> filteredList;

    public boolean isShowAll()
    {
        return showAll;
    }

    public void setShowAll(boolean showAll)
    {
        this.showAll = showAll;
        first = 0;
        rows = showAll ? 0 : 2;
        filteredList = null;

        // get the FacesContext instance
        FacesContext context = FacesContext.getCurrentInstance();

        // get the current component (p:selectBooleanCheckbox)
        UIComponent component = UIComponent.getCurrentComponent(context);

        // find DataTable within the same NamingContainer
        DataTable table = (DataTable) component.findComponent("values");

        // reset first row index
        table.setFirst(first);

        // reset last row index
        table.setRows(rows);

        // reset filterd value
        table.setFilteredValue(null);
    }

    // all other getters/setters
}