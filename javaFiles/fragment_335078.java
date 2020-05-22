@Override
public int getItemViewType(int position) {
    if (position % 5 == 0 && position != 0) {
        return VIEW_TYPE_BANNER;
    } else if (position == getItemCount() - 1) {
        // Last item. Return the loading view.
        return VIEW_TYPE_LOADING;
    } else {
        return VIEW_TYPE_ITEM;
    }
}

@Override
public int getItemCount() {
    return jokes == null ? 0 
        : jokes.size() + jokes.size() / 5 + 1;
}