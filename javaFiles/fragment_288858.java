public class OrdersFragment extends BaseCustomFragment
{

    ... 


    private Order currentOrder;

    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
        Order o = (Order) parent.getItemAtPosition(position);
        currentOrder = o;
        setContext(o.getCustomer(), o.getLocalization());

        return super.onItemLongClick(parent, view, position, id);
    }

    protected MenuItemAction createNewOrderMenuItem()
    {
        return new MenuItemAction("Copy Order")
        {
            @Override
            protected boolean isVisibleImpl(Customer conCon, Localization locCon)
            {
                return (OrdersFragment.this.currentOrder != null);
            }

            @Override
            protected void handleActionImpl(Customer conCon, Localization locCon)
            {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                intent.putExtra("copySrcId", OrdersFragment.this.currentOrder.getId());
                startActivity(intent);
            }
        };
    }