@Override
public int getItemViewType(int position) {
    return getItem(position).left ? 0 : 1;
}

@Override
public int getViewTypeCount() {
    return 2;
}