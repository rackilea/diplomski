Cursor csr = myDBHlpr.getAllQuestions2(getActivity());
while (csr.moveToNext()) {

    ...

    UsageHelper newListItem = new UsageHelper(name,sent,recieved,total,time);
    usage.add(newListItem);

    ...

}
mAdapter.notifyDataSetChanged();