public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
    // create a new view
    TextView v = (TextView) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.my_text_view, parent, false);
    ...
    MyViewHolder vh = new MyViewHolder(v);
    return vh;
}