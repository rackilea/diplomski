private boolean loading = false;
     private boolean isScrollCalled;
     int isLastPage = 10;
     int pageCount = 1;

     //Paigination
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int lastvisibleitemposition = linearLayoutManager.findLastVisibleItemPosition();

                if (lastvisibleitemposition == adapter.getItemCount() - 1) {

                    if (!loading && pageCount != isLastPage) {
                        loading = true;
                        jsonRequestList(++pageCount);
                        isScrollCalled = Boolean.TRUE;
                    }


                }
            }
        });


 private void jsonRequestList(int pageCount) {
  //Json Request

  if (!isScrollCalled) {
          adapter = new FlowerListAdapter(FlowerListActivity.this, list);
          recyclerView.setAdapter(adapter);
          adapter.notifyDataSetChanged();
               //  Log.e("LIST_SIZE", "" + list.size());
          } else {
          adapter.updateList(list);
          //Log.e("LIST_SIZE", "" + list.size());

        }

       loading = false;
}