public class LocalizationsFrag extends BaseCustomFragment
{
    public LocalizationsFrag()
    {

        ... 

        setMenus(
                createNavigateToLocationMenuItem(),
                createNewOrderMenuItem());
    }

    ... 

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
        Localization o = (Localization) parent.getItemAtPosition(position);
        setContext(null, o);
        return super.onItemLongClick(parent, view, position, id);
    }