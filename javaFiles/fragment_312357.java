@Override
protected void onResume() {
    super.onResume();
    sharedPreference.setListener(this);
    da.notifyDataSetChanged();

}