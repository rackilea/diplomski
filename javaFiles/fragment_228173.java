public class YourAdapterName extend RecyclerView.Adapter...
    private OnItemClickListener onItemClickListener

    void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener
    }

...

    @Override
    public void onBindViewHolder(@NonNull final CoordinatesViewHolder holder, int position) {
        final Coordinates coord = mCoordinates.get(position);
        holder.place_name.setText(coord.getmUPlaceName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null) {
                     onItemClickListener.onItemClicked(position)
                }
            }
        });
    }