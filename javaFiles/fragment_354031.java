@Override
public int getItemViewType (int position) {
    if(position == 0)
        return 0;
    else
        return 1;
}

@Override
public int getViewTypeCount () {
    return 2;
}