List<String> tmpList = new ArrayList<String>();
for (GraphUser tmp : friendList) {
  tmpList.add(tmp.getInnnerJSONObject().toString());
}
Intent intent = new Intent();
intent.putExtra("list", tmpList);
setResult(RESULT_OK, intent);
finish();