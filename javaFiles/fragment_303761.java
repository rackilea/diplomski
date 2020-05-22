private ArrayList<Branch> branchCopy = new ArrayList<>;
 public BranchAdapter(ArrayList<Branch> items) {
        branchArrayList = items;
        branchCopy.addAll(items);
        filter = new CustomFilter(BranchAdapter.this);
    }