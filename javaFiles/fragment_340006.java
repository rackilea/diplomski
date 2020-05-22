ArrayList<ContactModel> contactModels;
ArrayList<ContactModel> contactModels1;
Context context;
SharedPreferences prefs;
DbHelper dbHelper;
public ContactsAdapter(Context context, ArrayList<ContactModel> contacts) {
    this.context=context;
    prefs = context.getSharedPreferences("login", MODE_PRIVATE);
    contactModels=contacts;
    contactModels1=contacts;
    dbHelper=DbHelper.getInstance(context);
}
 public Filter getFilter() {
    return new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String charString = charSequence.toString();
            Log.i("--->", "performFiltering: "+charSequence);
            List<ContactModel>contactListFiltered;
            if (charString.isEmpty()) {
                contactListFiltered = contactModels1;
            } else {
                List<ContactModel> filteredList = new ArrayList<>();
                for (ContactModel row : contactModels1) {


                    if (row.getName().toLowerCase().contains(charString.toLowerCase()) ) {
                        filteredList.add(row);
                    }
                }

                contactListFiltered = filteredList;
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = contactListFiltered;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            contactModels = (ArrayList<ContactModel>) results.values;

            // refresh the list with filtered data
            notifyDataSetChanged();
        }
    };
}