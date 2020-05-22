@Override
public RecyclerMapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_row, parent, false);
    final RecyclerMapAdapter.ViewHolder viewHolder = new RecyclerMapAdapter.ViewHolder(v);
    v.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ListMapActivity mapsActivity = (ListMapActivity) context;
            Intent intent = new Intent(mapsActivity, DescriptionMapActivity.class);

            Features feature = features.get(viewHolder.getAdapterPosition());
            MyProperties myProperties = feature.getProperties();
            intent.putExtra("data", myProperties);
            mapsActivity.startActivity(intent);
        }
    });

    return viewHolder;
}