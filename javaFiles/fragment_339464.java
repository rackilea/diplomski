doInBackground(....) {
 mPseudoList.addAll(fetched_list);
 return xyz;
}

onPostExecute(...) {
 mAdapterList.addAll(mPseudoList);
 mAdapter.notifyDataSetChanged();
}