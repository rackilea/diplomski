mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                2, GridLayoutManager.VERTICAL, false));

      // Make sure your recyler view adapter implements getItemAt(position), which return the item from the dataset placed at position
      // in this case I use getProductId() from my POJO Product class

        ItemClickSupport.addTo(mRecyclerView)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Log.d("ITEM CLICK", "Item single clicked " + mRecyclerViewAdapter.getItemAt(position).getProductId());
                    }

                    @Override
                    public void onItemDoubleClicked(RecyclerView recyclerView, int position, View v) {
                        Log.d("ITEM CLICK", "Item double clicked " + mRecyclerViewAdapter.getItemAt(position).getProductId());
                    }
                });