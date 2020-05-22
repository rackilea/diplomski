public class CustomersFrag extends BaseCustomFragment
{
    public CustomersFrag()
    {

        ... 

        setMenus(createCallMenuItem(),
                 createSmsMenuItem(),
                 createEmailMenuItem(),
                 createNewOrderMenuItem(),
                 createNavigateToLocationMenuItem());
    }

    ... 

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
        Customer c = (Customer) parent.getItemAtPosition(position);
        setContext(c, c.getLocalization());
        return super.onItemLongClick(parent, view, position, id);
    }