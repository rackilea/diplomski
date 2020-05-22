public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    private int mTrackPlaying = -1;

    public void setTrackPlaying(int position) {
        mTrackPlaying = position;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.trackName.setText("Track " + position);
        if(position == mTrackPlaying) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(main, R.color.playing)); 
        } else {
            // Here, you must restore the color because the view is reused.. so, you may receive a reused view with wrong colors
            holder.itemView.setBackgroundColor(ContextCompat.getColor(main, R.color.NOT_playing)); 
        }
    }
}