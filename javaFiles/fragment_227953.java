public class PropertyListAdapter extends RecyclerView.Adapter<PropertyListAdapter.ViewHolder> {

    private List<Property> mPropertyList;

    public void setPropertyList(List<Property> propertyList) {
        mPropertyList = propertyList;
    }

    @Inject
    public PropertyListAdapter() {
    }

    // onCreateViewHolder()
    // onBindViewHolder()
    // getItemCount()
    // class ViewHolder{}
}