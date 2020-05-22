@Override
protected String doInBackground(Context... arg0) {
    // This just gets data from DB on background Thread
    mVoterArray = new ArrayList<AddressInfo>();
    mVoterArray = extDbUtil.getAddresslist(strAddress , limit += 20);

    return null;
}

@Override
protected void onPostExecute(Void v) {
    super.onPostExecute();

    // If the mVoterArray isnt null and if it isnt empty, then there is some data in there.
    if (mVoterArray != null && !mVoterArray.isEmpty()) {
        int position =  mListView.getLastVisiblePosition();
        mListAdapter = new ListAdapterNew2(mContext,
                android.R.layout.simple_list_item_1, mVoterArray);
        mListView.setAdapter(mListAdapter);
        mListView.setSelectionFromTop(position, 0);
        mListAdapter.notifyDataSetChanged();
    } else {
        ToastUtils.showToast(mContext, "No Record Found!!");
    }
}