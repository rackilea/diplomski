@Override
public int getItemViewType(int position) {

    if (position == 0 )
        return POSTER;
    else
        return CHILDGROUP;

}