@Override
    protected void onPostExecute(Object o) {
        dataList.clear();
        dataList.addAll((ArrayList)MessagingData.getMessageListData());
        adapter.notifyDataSetChanged();
        super.onPostExecute(o);
    }