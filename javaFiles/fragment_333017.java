@Override
public CharSequence getPageTitle(int position) {
    Typeface font = Typeface.createFromAsset( getAssets(), "fontawesome-webfont.ttf" );
    String title = "";

    if (position == current_position - 1) {
        title = "\uf137";
    } else if (position == current_position + 1) {
        title = "\uf138";
    }

    SpannableString styled = new SpannableString(title);
    styled.setSpan(new CustomTypefaceSpan(font), 0, title.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

    return styled;
}