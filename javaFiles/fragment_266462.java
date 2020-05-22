//load your desired numbers data to postList your (5 posts for this),  
    boolean isAlreadyLoading = false

                post.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);

                        if (postListManager != null) {


                             index = postManager.findFirstVisibleItemPosition();

                if(index > postList.size()-5 && !isAlreadyLoading)
                {
isAlreadyLoading=true;

        postAdapter.notifyDataSetChanged;
                }}}

loadNewData()
{
loadNewData(); //add new data to the end of the postList
isAlreadyLoading=false;
}