ContentValues defaultAcc = mapAccountToStorable(defaultAccDataModel = new AccountListRecyclerAdapter.AccountDataModel(
                        LBudgetUtils.getInt(mContext, "default_account_id"),
                        LBudgetUtils
                                .getString(mContext, "default_account_name"),
                        mContext.getResources().getBoolean(
                                R.bool.default_account_selected)));