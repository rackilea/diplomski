private void setTrackColor(int position) {
    TracksAdapter adapter = (TracksAdapter) recyclerView.getAdapter();
    adapter.setTrackPlaying(position);
    // Line below will `RecyclerView` to re-draw that position.. in other words, it will triggers a call to `onBindViewHolder`
    adapter.notifyItemChanged(position);

    // Reset the color of song previously playing.. 
    adapter.notifyItemChanged(oldPosition);
}