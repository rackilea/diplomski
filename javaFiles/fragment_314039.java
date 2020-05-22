@Override
public int getItemViewType(int position) {
    // Define a way to determine which layout to use, here it's just evens and odds.
    return position % 2;
}

@Override
public int getViewTypeCount() {
    return 2; // Count of different layouts
}