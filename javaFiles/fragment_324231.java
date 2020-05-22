@Override
protected void publishResults(CharSequence constraint, FilterResults results) {
    if (results != null && results.count > 0) {
        ArrayList<String> filteredList = (ArrayList<String>) results.values.clone();
        clear();
        for (String c : filteredList) {
            add(c);
        }
        notifyDataSetChanged();
    }
}