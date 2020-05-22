public class RestaurantsViewHolder extends RecyclerView.ViewHolder {
public TextView RestaurantName, date, time;
public ImageLoader imageLoader;

public RestaurantsViewHolder(View itemView) {
    super(itemView);

    thumbNail = (ImageView) itemView.findViewById(R.id.thumbnail);
    RestaurantName = (TextView) itemView.findViewById(R.id.RestaurantName);
    date = (TextView) itemView.findViewById(R.id.date);
    time = (TextView) itemView.findViewById(R.id.time);
    }
}