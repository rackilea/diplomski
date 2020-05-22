@Override
public GameTableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.but_item, parent, false);
    mainView = parent;
    return new GameTableAdapter.ViewHolder(view);
}