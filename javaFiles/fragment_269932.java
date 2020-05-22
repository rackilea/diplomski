@Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults fr = null;
        if (constraint != null)
        {
            List<ListItem> list = getFilterdValues(constraint.toString());

            if (list != null)
            {
                fr = new FilterResults();
                fr.values = list;
                fr.count = list.size();
            }
        }
        return fr;
    }