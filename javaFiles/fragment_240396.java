//Progress bar setVisibility - Visible
progressbar.setVisibility(View.VISIBLE);
fetch.fetchApiData(fpage, new FetchWpApi.Callback() {
  @Override
  public void onSuccess(sItem sitem) {
    progressbar.setVisibility(View.GONE);
    list.add(sitem);
    recyclerView.getAdapter().notifyDataSetChanged();
    recyclerView.getAdapter().notifyItemRangeChanged(0, recyclerView.getAdapter().getItemCount());

  }
  @Override
  public void onFail(String msg) {
    progressbar.setVisibility(View.GONE);
    Toast.makeText(context, "FAILED ONLOAD", Toast.LENGTH_LONG).show();
  }
});