@Override
    protected void publishResults(CharSequence constraint,
            FilterResults results) {
        AutoCompleteAdapter.this.clear();
        if (results != null)
        {
            if (results.values != null)
            {
                List<ListItem> items = (List<ListItem>) results.values;

                    for (ListItem listItem : items) {
                        AutoCompleteAdapter.this.add(listItem);
                    }

                if (items.size() > 0)
                {
                    AutoCompleteAdapter.this.notifyDataSetChanged();
                    return;
                }
            }
        }
        AutoCompleteAdapter.this.notifyDataSetInvalidated();
    }