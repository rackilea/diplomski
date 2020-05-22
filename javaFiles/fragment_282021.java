private void LockOrUnlockButtons() throws Exception {
    boolean anyCustomers = !sngltn.GetAllCustemers().isEmpty();
    buttonUpdateAddActivityCstmrCrd.setEnabled(anyCustomers);
    buttonDeleteCstmrCrd.setEnabled(anyCustomers);
    buttonQueriesViewData.setEnabled(anyCustomers);
}