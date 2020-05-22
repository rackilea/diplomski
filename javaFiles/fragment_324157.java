@Override
protected void onPostExecute(String result) {
    super.onPostExecute(result);

    EventBus.getDefault().post(new MyEvent(jsonArray.toString()));
}