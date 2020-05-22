@Override
public View getView(int position, View convertView, ViewGroup container) {
    ...
    if (position == currentlyPlayingPosition) {
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
    } else {
        textView.setTypeface(textView.getTypeface(), Typeface.NORMAL);
    }
    ...
}