FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<POJO, SingleImageViewHolder>(options) {
@Override
public SingleImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // Create a new instance of the ViewHolder, in this case we are using a custom
    // layout called R.layout.message for each item
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.message, parent, false);

    return new SingleImageViewHolder(view);
}

@Override
protected void onBindViewHolder(SingleImageViewHolder holder, int position, POJO model) {
    // Bind the Chat object to the ChatHolder
    // ...
   }
};