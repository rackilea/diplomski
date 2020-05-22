@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == ADD_DEADLINE_REQUEST){
        if (resultCode == RESULT_OK) {
            String item = data.getStringExtra("result");
            arrayList.add(item);
            adapter.notifyDataSetChanged();
        }
    }
}