Branch branch = null;
try {
    branch = pm.getObjectById(Branch.class, branchId);
    branch.getAddress();
}
catch (JDOObjectNotFoundException onfe) {
    // not found
}
catch (Exception e) {
    // failed
}
finally {
    pm.close();
}