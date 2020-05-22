public class BreakingNewsAdapter {

    private List<BreakingNews> news;
    private int adapterSize = 0;

    public void setNews(List<BreakingNews> news) {
        this.news = news;
        this.adapterSize = news.size(); // some initialization
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (this.news != null)
            return this.adapterSize;
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BreakingNews item = news.get(position % news.size()); // the '%' will ensure you'll always have data to bind to the view holder

        if (position == this.adapterSize - 1) {
            this.adapterSize += news.size(); // do whatever you want here, just make sure to increment this.adapterSize's value 
            new Handler().postDelayed(() -> notifyItemInserted(position + 1), 100); // Can't notify directly from this method, so we use a Handler. May change the delay value for what works best for you.
            // notifyItemInserted will animate insertion of one item to your list. You may call to notifyDataSetChanged or notifyItemRangeInserted if you don't want the animation

            //new Handler().postDelayed(() -> notifyItemRangeInserted(position + 1, this.adapterSize - news.size()), 100);
            //new Handler().postDelayed(this::notifyDataSetChanged, 100);
        }
    }
}