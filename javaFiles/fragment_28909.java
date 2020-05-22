protected FilterResults performFiltering(CharSequence constraint) {
        // NOTE: this function is *always* called from a background thread,
        // and
        // not the UI thread.
        String constraintStr = constraint.toString().toLowerCase();
        FilterResults result = new FilterResults();

        if (constraint != null && constraint.toString().length() > 0) {
            ArrayList<Company> filterItems = new ArrayList<Company>();

            synchronized (this) {
                for (int i = 0; i < mItems.size(); i++) {
                    Company company=mItems.get(i);
                    String companyName= company.companyName;
                    if (companyName.toLowerCase().startsWith(constraintStr)) {
                        filterItems.add(company);
                    }
                }
                result.count = filterItems.size();
                result.values = filterItems;
            }
        } else {
            synchronized (this) {
                result.count = mItems.size();
                result.values = mItems;
            }
        }
        return result;
    }