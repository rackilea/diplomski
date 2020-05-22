@Override
  protected FilterResults performFiltering(CharSequence constraint) {
        ArrayList<Branch> branchFilter = new ArrayList<>;
        final FilterResults results = new FilterResults();
            if (constraint.length() == 0) {
                branchFilter.addAll(branchArrayList);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();
                for (final Branch branch : branchCopy) {
                    if (branch.getBranchName().toLowerCase().startsWith(filterPattern)) {
                        branchFilter.add(branch);
                    }
                }
            }
            results.values = branchFilter ;
            results.count = branchFilter.size();
            return results;
        }