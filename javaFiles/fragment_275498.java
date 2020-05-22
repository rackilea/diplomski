rv.addOnScrollListener(new RecyclerView.OnScrollListener() {


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        try {

            LinearLayoutManager layoutManager = ((LinearLayoutManager) rv.getLayoutManager());
            int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();


            Log.e("refresh", "State - " + newState + " : firstVisiblePosition" + firstVisiblePosition);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }