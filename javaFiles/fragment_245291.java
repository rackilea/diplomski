query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                ProductModel productModel = document.toObject(ProductModel.class);
                list.add(productModel);
            }
            productAdapter.notifyDataSetChanged();
            lastVisible = task.getResult().getDocuments().get(task.getResult().size() - 1);

            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                        isScrolling = true;
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    LinearLayoutManager linearLayoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
                    int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    int visibleItemCount = linearLayoutManager.getChildCount();
                    int totalItemCount = linearLayoutManager.getItemCount();

                    if (isScrolling && (firstVisibleItemPosition + visibleItemCount == totalItemCount) && !isLastItemReached) {
                        isScrolling = false;
                        Query nextQuery = productsRef.orderBy("productName", Query.Direction.ASCENDING).startAfter(lastVisible).limit(limit);
                        nextQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> t) {
                                if (t.isSuccessful()) {
                                    for (DocumentSnapshot d : t.getResult()) {
                                        ProductModel productModel = d.toObject(ProductModel.class);
                                        list.add(productModel);
                                    }
                                    productAdapter.notifyDataSetChanged();
                                    lastVisible = t.getResult().getDocuments().get(t.getResult().size() - 1);

                                    if (t.getResult().size() < limit) {
                                        isLastItemReached = true;
                                    }
                                }
                            }
                        });
                    }
                }
            };
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }
});