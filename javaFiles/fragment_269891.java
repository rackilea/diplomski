recyclerView.addOnItemTouchListener(new BlogRecyclerAdapter.RecyclerItemClickListener(getActivity(), recyclerView ,new BlogRecyclerAdapter.RecyclerItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {

                    // Do something here...
                }

                @Override public void onLongItemClick(View view, int position) {

                }
            })
    );