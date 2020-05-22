public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder> {

private List<Event> mData;
private LayoutInflater mInflater;
private ItemClickListener mClickListener;

// data is passed into the constructor
public EventsRecyclerViewAdapter(List<Event> data) {
    this.mInflater = LayoutInflater.from(MainActivity.mainActivity);
    this.mData = data;
}

// inflates the row layout from xml when needed
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
    return new ViewHolder(view);
}

// binds the data to the TextView in each row
@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    Event event = mData.get(position);
    holder.keyID.setText(event.keyID);
    holder.lockID.setText(event.lockId);
    holder.eventTime.setText(event.eventTime);
    holder.eventType.setText(event.eventType);
}

// total number of rows
@Override
public int getItemCount() {
    return mData.size();
}


// stores and recycles views as they are scrolled off screen
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView keyID;
    TextView lockID;
    TextView eventTime;
    TextView eventType;

    ViewHolder(View itemView) {
        super(itemView);
        keyID = itemView.findViewById(R.id.keyIDTV);
        lockID = itemView.findViewById(R.id.lockIDTV);
        eventTime = itemView.findViewById(R.id.eventDateTV);
        eventType = itemView.findViewById(R.id.eventTypeTV);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }
}




// parent activity will implement this method to respond to click events
public interface ItemClickListener {
    void onItemClick(View view, int position);
}