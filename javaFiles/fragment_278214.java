@Override
public int getViewTypeCount() {
    return 3;
}

@Override
public int getItemViewType(int position) {
    return getItem(position).getChanneltype() - 1;
}