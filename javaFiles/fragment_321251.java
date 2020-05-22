branch = pm.getObjectById(Branch.class, branchId);
pm.close();
branch.getAddress();  // this is null

branch = pm.getObjectById(Branch.class, branchId);
branch.getAddress();  // this is not null
pm.close();
branch.getAddress();  // neither is this