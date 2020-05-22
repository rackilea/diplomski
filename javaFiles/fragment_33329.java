@RequestMapping(value = "{id}", method = RequestMethod.POST)
public Account update(@PathVariable Integer id, @RequestBody Account account){
    Account acc = dao.getById(id);
    acc.copy(account);
    dao.update(acc);
}

class Account {
     ....
    public void copy(final Account account) {
         if (account.prop1 != null) {
             this.prop1 = account.prop1;
         }
         // update the mutable fields
         .....
    }
}