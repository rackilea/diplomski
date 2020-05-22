public abstract class BaseCategoryListActivity extends ListActivity
{
    ....
    public abstract ArrayList<String> getListItems();
    ....
}

public class AthleticsNewsActivity extends BaseCategoryListActivity
{
    ....
    public ArrayList<String> getListItems()
    {
       ...implementation details....
    }
}