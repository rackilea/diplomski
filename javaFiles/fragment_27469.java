public class FeedViewHolder extends RecyclerView.ViewHolder {
    private TextView feedText;
    private TextView surNameText;
    private Button interestedButton;
    // ... the rest of your viewholder elements

    public FeedViewHolder(View itemView) {
        super(itemView);

        feedtext = itemView.findViewById(R.id.feedtext);
        // ... find your other views

        interestedButton.setOnClickListener(new View.OnClickListener() {
            final FeedInfo fi = feedInfoList.get(getAdapterPosition());
            int numInterested = Integer.parseInt(ci.getNumber_of_interested()) + 1;

            // setting the views here might work, 
            // but you will find that they reset themselves
            // after you scroll up and down (views get recycled).

            // find a way to update feedInfoList, 
            // I like to use EventBus to send an event to the
            // host activity/fragment like so:
            EventBus.getDefault().post(
                new UpdateFeedInfoListEvent(getAdapterPosition(), numInterested));

            // in your host activity/fragment, 
            // update the list and call 
            // notifyDatasetChanged/notifyDataUpdated() 
            //on this RecyclerView adapter accordingly
        });
    }
}