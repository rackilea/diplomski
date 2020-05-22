@Override
public View getInfoContents(Marker marker) {

    Context mContext = getActivity();

    LinearLayout info = new LinearLayout(mContext);
    info.setOrientation(LinearLayout.VERTICAL);

    TextView title = new TextView(mContext);
    title.setTextColor(Color.BLACK);
    title.setGravity(Gravity.CENTER);
    title.setTypeface(null, Typeface.BOLD);
    title.setText(marker.getTitle());
    title.setSingleLine(false);

    info.addView(title);

    if (marker.getSnippet() != null) {
        TextView snippet = new TextView(mContext);
        snippet.setTextColor(Color.GRAY);
        snippet.setText(marker.getSnippet());
        snippet.setSingleLine(false);

        info.addView(snippet);
    }

    return info;
}