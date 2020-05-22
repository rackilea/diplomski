private ArrayList<String> originalList; // I used String objects in my tests
private ArrayList<String> filteredList;
private ListFilter filter = new ListFilter();

@Override
public int getCount() {
    return filteredList.size();
}

public Filter getFilter() {
    return filter;
}

private class ListFilter extends Filter {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toLowerCase();
            final List<String> list = originalList;
            int count = list.size();

            final ArrayList<String> nlist = new ArrayList<>(count);
            String filterableString;
            for (int i = 0; i < count; i++) {
                filterableString = list.get(i);
                if (filterableString.toLowerCase().contains(constraint)) {
                    nlist.add(filterableString);
                }
            }

            results.values = nlist;
            results.count = nlist.size();
        } else {
            synchronized(this) {
                results.values = originalList;
                results.count = originalList.size();
            }
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results.count == 0) {
            notifyDataSetInvalidated();
            return;
        }

        filteredList = (ArrayList<String>) results.values;
        notifyDataSetChanged();
    }
}