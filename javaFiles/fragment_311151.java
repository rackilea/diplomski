mList.add("Button add " +0);
    mAdapter.notifyItemInserted(mList.size()-1);

    //Again it's showing but never notify
    mList.add("Button add " +1);
    mList.add("Button add " +2);