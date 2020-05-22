public class FilterableAdapter extends BaseAdapter {
    private List<Filter> _filters = new ArrayList<Filter>();
    private List<Event> _items = null;
    private List<Event> _filteredItems = new ArrayList<Filter>();

    public void addFilter(Filter filter) {
        _filters.add(filter);
        _filterItems();
    }

    public void removeFilter(Filter filter) {
        _filters.remove(filter);
        _filterItems();
    }

    public List<Filter> getFilters() {
        return _filters;
    }

    public void setItems(List<Event> items) {
        _items = items;
        _filterItems();
    }

    private void _filterItems() {
        _filteredItems.clear();
        for (Filter filter : _filters) {
            for (Event event : _items) {
                if (filter.filter(event)) {
                     _filteredItems.add(event);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public void getItem(int position) {
        return _filteredItems.get(position);
    }

    @Override
    public void getCount() {
        return _filteredItems.size();
    }
}