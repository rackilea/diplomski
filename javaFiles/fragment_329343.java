// in the performFiltering method which runs on a background thread:
@Override
protected FilterResults performFiltering(CharSequence constraint) {
     FilterResults filterResults = new FilterResults();
     ArrayList<String> queryResults;
     if (constraint != null && constraint.length() > 0) {
         queryResults = autocomplete(constraint);
     } else {
         queryResults = new ArrayList<String>(); // empty list/no suggestions showing if there's no valid constraint
     }
     filterResults.values = queryResults;
     filterResults.count = queryResults.size();
     return filterResults; // ## Heading ##
}

private List<String> autocomplete(String input) {
   // don't use the here the resultList List on which the adapter is based!
   // some custom code to get items from http connection
     ArrayList<String> queryResults = new ArrayList<String>(); // new list
     queryResults.add("Some String");
     return queryResults;
}

@Override
protected void publishResults(CharSequence constraint, FilterResults results) {
     // update the data with the new set of suggestions
     resultList = (ArrayList<String>)results.values;
     if (results.count > 0) {
         notifyDataSetChanged();
     } else {
         notifyDataSetInvalidated();
     }
}