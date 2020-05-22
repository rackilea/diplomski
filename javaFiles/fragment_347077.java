@Override
public int getViewTypeCount() {
    return 4;
}

@Override
public int getItemViewType(int position) {
    return rowFinder[position] - 1;
}