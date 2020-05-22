visibleItemCount = rvProfile.getChildCount();
            totalItemCount = linearLayoutManager.getItemCount();
            firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                }
            }
            if (!loading && (visibleItemCount + firstVisibleItem) >= totalItemCount
                    && firstVisibleItem >= 0
                    && totalItemCount >= totalPages) {
                profileListPresenter.getMoreData(pageNo);
                loading = true;
            }