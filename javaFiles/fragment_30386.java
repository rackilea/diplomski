public interface MenuListener {
    void setMenuItemVisible(boolean state);
}

private MenuListener mListener;
private Item[] mListItems; // The list of items that your adapter handles

public void setMenuListener(MenuListener listener) {
    mListener = listener;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ListView listview = convertView.findViewById(R.id.yourListViewId);
    if (mListItems.size() > 0) {
        mListener.setMenuItemVisible(true);
    } else {
        mListener.setMenuItemVisible(false);
    }

}