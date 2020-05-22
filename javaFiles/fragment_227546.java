new TransactionCallback<Person>() {

    @Override
    public Person doInTransaction(TransactionStatus status) {
      // ...
      return person
    }

    // ...
});