@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    if (viewType == POSTER) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listrow_auto_viewpager, parent, false);
        return new PosterSliderHolder(view);
    } else {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listrow_sub_category, parent, false);
        return new GroupViewHolder(view);
    }
}