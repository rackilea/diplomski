public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextView;
    public ViewHolder(View v) {
        super(v);
        // Find the TextView in the LinearLayout
        mTextView = v.findViewById(R.id.textView));
    }
}

@Override
public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.my_text_view, parent, false);
    // Give the view as it is
    ViewHolder vh = new ViewHolder(v);
    return vh;
}