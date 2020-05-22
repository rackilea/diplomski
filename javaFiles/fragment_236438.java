//Update a person
    public boolean updateContact(long rowId, Person p){
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, p.getName());
        args.put(KEY_PHONE, p.getPhone());
        args.put(KEY_ACCOUNT, p.getAccount());
        args.put(KEY_BANK, p.getBank());
        args.put(KEY_BANK_IFSC, p.getBankIfsc());
        String where = KEY_NAME + "= '" + p.getName() + "'";
        return db.update(DATABASE_TABLE, args, where, null) != 0;
    }