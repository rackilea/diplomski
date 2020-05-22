@Override
public void setContentView(int layoutResID) {
    if (frameLayout != null) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        View stubView = inflater.inflate(layoutResID, frameLayout, false);
        frameLayout.addView(stubView, lp);

    }
}