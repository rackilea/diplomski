ArrayList<String> YOUR_ARRAYLIST = new ArrayList<>();
        for (int i = 0; i < YOUR_ARRAYLIST.size(); i++) {
            YOUR_ARRAYLIST.add(String.valueOf(i));
        }
        /**
         * After populating the data on ArrayList than u need to update OR intilaize the  Recyclview
         */


        if (mAdapter!=null) {
            mAdapter = new YOUR_ADAPTER(this, YOUR_ARRAYLIST);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            YOUR_RECYCLVIEW.setLayoutManager(mLayoutManager);
            YOUR_RECYCLVIEW.setItemAnimator(new DefaultItemAnimator());
            YOUR_RECYCLVIEW.setAdapter(mAdapter);

        }
        else
        {
            mAdapter.notifyDataSetChanged();
        }