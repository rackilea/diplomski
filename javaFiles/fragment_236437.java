//Update a person
public void updateContact(long rowId, Person p){
    ContentValues args = new ContentValues();
    args.put(KEY_NAME, p.getName());
    args.put(KEY_PHONE, p.getPhone());
    args.put(KEY_ACCOUNT, p.getAccount());
    args.put(KEY_BANK, p.getBank());
    args.put(KEY_BANK_IFSC, p.getBankIfsc());
}