public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    private PlaceCallActivity placeCallActivity;
    private static String str;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
        // this.placeCallActivity now references the parent activity instance
        this.placeCallActivity=(PlaceCallActivity)context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);

        holder.imageViewProfile.setImageResource(listItem.getImage());
        holder.textViewName.setText(listItem.getName());
        holder.textViewBio.setText(listItem.getBio());

        /*Picasso.with(context)
                .load(listItem.getImageUrl())
                .into(holder.imageView);
*/
//        str = listItem.getName();

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked " + listItem.getName(), Toast.LENGTH_SHORT).show();
                placeCallActivity.callButtonClicked(listItem.getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName, textViewBio;
        public ImageView imageViewProfile;
        public Button callButton;

        ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewBio = (TextView) itemView.findViewById(R.id.textViewBio);
            imageViewProfile = (ImageView) itemView.findViewById(R.id.imageViewProfile);
            callButton = (Button) itemView.findViewById(R.id.callButton);


        }
    }

    public static String getStr() {
        return str;
    }
}