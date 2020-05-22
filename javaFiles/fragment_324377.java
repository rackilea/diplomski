db.beginTransaction();
    db.execSQL(createAccTableCmd);
    db.execSQL(oneAndOnlyOneSelectedAccInsertTriggerCmd);
    db.execSQL(oneAndOnlyOneSelectedUpdateTriggerCmd);
    db.setTransactionSuccessful();
    db.endTransaction();

    db.beginTransaction();
    addTableName(ACCOUNTS_TABLE_NAME);
    AccountListRecyclerAdapter.AccountDataModel defaultAccDataModel;
    ContentValues defaultAcc = mapAccountToStorable(defaultAccDataModel = new AccountListRecyclerAdapter.AccountDataModel(LBudgetUtils.getInt(mContext, "default_account_id"), LBudgetUtils.getString(mContext, "default_account_name"), mContext.getResources().getBoolean(R.bool.default_account_selected)));
    Log.d("debug", "-1 if error on insert: " + db.insert(ACCOUNTS_TABLE_NAME, null, defaultAcc));
    db.setTransactionSuccessful();
    db.endTransaction();


    Log.d("debug", "Size: " + db.query(ACCOUNTS_TABLE_NAME, null, null, null, null, null, ACCOUNT_KEY_ID + " ASC").getCount());