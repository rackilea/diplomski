@Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgD = ProgressDialog.show(mContext, "", "Wait", true);
        ih = new InsertHelper(mDatabase, "dictionary");
        wordColumn = ih.getColumnIndex("word");
    }