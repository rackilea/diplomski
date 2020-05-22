@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.but_item, parent, false);
    parent.removeView(view);
    parent.addView(view);
    mainView = parent;
    return new ViewHolder(view);
}