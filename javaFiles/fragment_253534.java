//populated transaction list

protected void populateTransactionList() {

    Intent depositIntent = getIntent();
    Transaction deposit = depositIntent.getParcelableExtra("data");
}