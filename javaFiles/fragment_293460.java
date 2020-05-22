//Inside your onCreate add the below code 

        mAdapter = new CommentsListAdapter (this);
        content_newsCommentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        content_newsCommentsRecyclerView.setAdapter(mAdapter);

//Call this inside your success of onResponse
commentsListAdapter.addAllItems(commentModel);