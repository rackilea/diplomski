public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Timeline> timeline;


    public RecyclerAdapter(Context context, ArrayList<Timeline> timeline) {
        this.context = context;
        this.timeline = timeline;



    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.timeline_row, parent, false);
        TimelineViewHolder holder = new TimelineViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        final String post_key = timeline.get(position).getPostkey();

        ((TimelineViewHolder) holder).setUsername(timeline.get(position).getUsername());


 }

    @Override
    public int getItemCount() {
        return timeline.size();
    }

    public class TimelineViewHolder extends RecyclerView.ViewHolder {
        public TimelineViewHolder(View itemView) {
            super(itemView);

            view = itemView;
        }

        public View getView() {
            return view;
        }    

        public void setUsername(String username) {
            TextView usernameTxtView = (TextView) view.findViewById(R.id.timeline_username);
            usernameTxtView.setText(username);
        }

    }
}